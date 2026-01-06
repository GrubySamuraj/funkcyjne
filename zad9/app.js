const express = require("express");
const {
  Worker,
  isMainThread,
  parentPort,
  workerData,
} = require("worker_threads");
const os = require("os");

if (!isMainThread) {
  const localData = workerData;
  const localMap = {};

  localData.forEach((record) => {
    if (record.student && record.hours) {
      if (!localMap[record.student]) {
        localMap[record.student] = 0;
      }
      localMap[record.student] += record.hours;
    }
  });

  parentPort.postMessage(localMap);
  process.exit(0);
} else {
  const app = express();
  const port = 3000;

  app.use(express.json());

  app.post("/binary", async (req, res) => {
    const { number } = req.body;

    if (number === undefined) {
      return res.status(400).json({ error: "Brak pola 'number'" });
    }

    const isPrime = await new Promise((resolve) => {
      if (number < 2) return resolve(false);
      const limit = Math.sqrt(number);
      for (let i = 2; i <= limit; i++) {
        if (number % i === 0) {
          return resolve(false);
        }
      }
      resolve(true);
    });

    res.json({
      number: number,
      isPrime: isPrime,
    });
  });

  app.post("/sortedList", async (req, res) => {
    const { list } = req.body;

    const sortedList = await new Promise((resolve) => {
      const sorted = [...list].sort((a, b) => a - b);
      resolve(sorted);
    });

    res.json({
      list: list,
      sorted: sortedList,
    });
  });

  app.post("/mapReduce", async (req, res) => {
    const inputData = req.body.list || req.body.data;

    const chunkArray = (array, numChunks) => {
      const chunks = [];
      const size = Math.ceil(array.length / numChunks);
      for (let i = 0; i < array.length; i += size) {
        chunks.push(array.slice(i, i + size));
      }
      return chunks;
    };

    const runWorker = (dataChunk) => {
      return new Promise((resolve, reject) => {
        const worker = new Worker(__filename, { workerData: dataChunk });
        worker.on("message", resolve);
        worker.on("error", reject);
        worker.on("exit", (code) => {
          if (code !== 0)
            reject(new Error(`Worker stopped with exit code ${code}`));
        });
      });
    };

    const reduceResults = (resultsArray) => {
      const finalMap = {};
      resultsArray.forEach((partialMap) => {
        for (const [student, hours] of Object.entries(partialMap)) {
          if (!finalMap[student]) {
            finalMap[student] = 0;
          }
          finalMap[student] += hours;
        }
      });
      return finalMap;
    };

    try {
      const numCPUs = os.cpus().length;
      const dataChunks = chunkArray(inputData, numCPUs);

      const workerPromises = dataChunks.map((chunk) => runWorker(chunk));
      const partialResults = await Promise.all(workerPromises);

      const finalResult = reduceResults(partialResults);

      res.json(finalResult);
    } catch (err) {
      res.status(500).json({ error: err.message });
    }
  });

  app.listen(port, () => {
    console.log(`App running on port ${port}`);
  });
}

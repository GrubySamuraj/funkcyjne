const express = require('express')
const app = express()
const port = 3000
app.use(express.json());
app.get('/', (req, res) => {
    res.send('Hello World!')
})

app.post("/binary", async (req, res) => {
    const { number } = req.body;
    const isPrimse = await new Promise((resolve, reject) => {
        if (body.number < 2)
            return resolve(false)
        const limit = Math.sqrt(number)
        for (let i = 2; i <= limit; i++) {
            if (number % i === 0) {
                return resolve(false)
            }
        }
        resolve(true)
    });
    res.json({
        number: number,
        isPrimse: isPrimse
    })
});

app.post("sortedList", async (req, res) => {
    const { list } = req.body;
    const sortedList = await new Promise((req, res) => { return list.sort() })
    res.json({
        list: list,
        sorted: sortedList
    })
})


app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})

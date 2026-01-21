const { app } = require('@azure/functions');

app.http('binary', {
    methods: ['POST'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        let body;
        try {
            body = await request.json();
        } catch (error) {
            return { status: 400, body: "Błędny format JSON" };
        }

        const { number } = body;

        if (number === undefined) {
            return { status: 400, jsonBody: { error: "Brak pola 'number'" } };
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

        return {
            jsonBody: {
                number: number,
                isPrime: isPrime,
            }
        };
    }
});

app.http('sortedList', {
    methods: ['POST'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        let body;
        try {
            body = await request.json();
        } catch (error) {
            return { status: 400, body: "Błędny format JSON" };
        }

        const { list } = body;

        if (!Array.isArray(list)) {
            return { status: 400, jsonBody: { error: "Brak pola 'list' lub nie jest tablicą" } };
        }

        const sortedList = [...list].sort((a, b) => a - b);

        return {
            jsonBody: {
                list: list,
                sorted: sortedList,
            }
        };
    }
});

app.http('mapReduce', {
    methods: ['POST'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        let body;
        try {
            body = await request.json();
        } catch (error) {
            return { status: 400, body: "Błędny format JSON" };
        }

        const inputData = body.list || body.data;

        if (!Array.isArray(inputData)) {
            return { status: 400, jsonBody: { error: "Brak danych wejściowych (list lub data)" } };
        }
        const localMap = {};
        inputData.forEach((record) => {
            if (record.student && record.hours) {
                if (!localMap[record.student]) {
                    localMap[record.student] = 0;
                }
                localMap[record.student] += record.hours;
            }
        });
        return {
            jsonBody: localMap
        };
    }
});
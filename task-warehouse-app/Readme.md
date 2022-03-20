результаты методов получены после обработки файла с фейковыми данными (лежит в корне проекта fakeData.csv).
Логика учитывает вероятность повторения данных в csv файле и сохраняет в базу только новые данные.
Также приложены скрины ответов из Postman.

localhost:8080/products?date=2022-02-20

[
    {
        "name": "spagetti",
        "price": 70.0
    },
    {
        "name": "milk",
        "price": 90.0
    },
    {
        "name": "oil",
        "price": 250.0
    }
]


localhost:8080/statistic

{
    "amount": 10,
    "priceFrequencyByProduct": [
        {
            "name": "bread",
            "frequency": 3
        },
        {
            "name": "buckwheat",
            "frequency": 5
        },
        {
            "name": "rice",
            "frequency": 4
        },
        {
            "name": "spagetti",
            "frequency": 6
        },
        {
            "name": "coffee",
            "frequency": 6
        },
        {
            "name": "tea",
            "frequency": 6
        },
        {
            "name": "milk",
            "frequency": 6
        },
        {
            "name": "lemons",
            "frequency": 4
        },
        {
            "name": "oil",
            "frequency": 6
        },
        {
            "name": "butter",
            "frequency": 4
        }
    ],
    "priceFrequencyByDate": [
        {
            "date": "2022-02-12",
            "frequency": 10
        },
        {
            "date": "2022-02-14",
            "frequency": 10
        },
        {
            "date": "2022-02-15",
            "frequency": 4
        },
        {
            "date": "2022-02-16",
            "frequency": 2
        },
        {
            "date": "2022-02-17",
            "frequency": 3
        },
        {
            "date": "2022-02-18",
            "frequency": 1
        },
        {
            "date": "2022-02-19",
            "frequency": 2
        },
        {
            "date": "2022-02-20",
            "frequency": 3
        },
        {
            "date": "2022-02-21",
            "frequency": 2
        },
        {
            "date": "2022-02-22",
            "frequency": 3
        },
        {
            "date": "2022-02-23",
            "frequency": 3
        },
        {
            "date": "2022-02-24",
            "frequency": 3
        },
        {
            "date": "2022-02-25",
            "frequency": 2
        },
        {
            "date": "2022-02-26",
            "frequency": 2
        }
    ]
}

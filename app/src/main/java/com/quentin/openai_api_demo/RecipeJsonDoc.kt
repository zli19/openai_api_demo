package com.quentin.openai_api_demo


val recipeSchema = """
{
    "title": "<The dish name>",
    "ingredients": [
        {
            "name": "<The name of the ingredient>",
            "amount": "<The amount of the ingredient needed, specify the unit>",
            "pretreatment": "<If the ingredient need any pretreatment, put it here, could be None>"
        }
    ],
    "servings": <number of servings for this recipe>,
    "instructions": [
        {
            "index": <index of steps>,
            "description": "<Details of this step of the instructions>"
        },
    ],
}""".trimIndent()

val userMessageSample = "potato tuna"

val assistantMessageSample = """
{
    "title": "Fresh Tuna and Red Potato Salad",
    "ingredients": [
        {
            "name": "Medium Red Potatoes",
            "amount": "1 lb",
            "pretreatment": "None"
        },
        {
            "name": "Yellow Fin Tuna",
            "amount": "3 c",
            "pretreatment": "Grilled And Cut Into 1-Inch Pieces"
        },
        {
            "name": "Celery Stalks",
            "amount": "4 md",
            "pretreatment": "Chopped, About 2 Cups"
        },
        {
            "name": "Fat Free Plain Yogurt",
            "amount": "1 c",
            "pretreatment": "None"
        },
        {
            "name": "Ground Black Pepper",
            "amount": "1/4 ts ,
            "pretreatment": "None"
        },
    ],
    "servings": 6,
    "instructions": [
        {
            "index": 1,
            "description": "Heat 1-Inch water (salted if desired) to boiling in a 2-quart saucepan. Add the potatoes and cover. Heat until boiling then reduce the heat until simmering and simmer the potatoes 30 to 35 minutes or until they are tender, then drain and cool slightly."
        },
        {
            "index": 2,
            "description": "Cut the potatoes into cubes, (There should be about 3 cups). Mix all of the ingredients together then cover and refrigerate about 1 hour or until well chilled. "
        },
    ],
}""".trimIndent()
package com.quentin.openai_api_demo


import com.aallam.openai.api.chat.*
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI

// Generate recipe in Json format with provided ingredients
suspend fun main() {
    val token = System.getenv("OPENAI_API_KEY")
    val openAI = OpenAI(token!!)
    println("\n> Create Chat Completion call...")
    val modelId = ModelId("gpt-3.5-turbo-1106")


    val chatMessages2 = mutableListOf(
        chatMessage {
            role = ChatRole.System
            content = """
                You are a helpful assistant that generate recipe based on provided ingredients.
                Provide your answer in JSON structure like this: $recipeSchema
            """.trimIndent()
        },
        chatMessage {
            role = ChatRole.User
            content = userMessageSample
        },
        chatMessage {
            role = ChatRole.Assistant
            content = assistantMessageSample
        },
        chatMessage {
            role = ChatRole.User
            content = "beef tomato"
        }
    )
    val request = chatCompletionRequest {
        responseFormat = ChatResponseFormat.JsonObject
        model = modelId
        messages = chatMessages2
    }

    val response = openAI.chatCompletion(request)
    val message = response.choices.first().message

    println("\n> Generated content:")
    println(message.content)
}
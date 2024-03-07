package com.quentin.openai_api_demo


import com.aallam.openai.api.chat.*
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI

// Compose a poem to explain programming concepts
suspend fun main() {
    val token = System.getenv("OPENAI_API_KEY")
    val openAI = OpenAI(token!!)
    println("\n> Create Chat Completion call...")
    val modelId = ModelId("gpt-3.5-turbo-1106")


    val chatMessages1 = mutableListOf(
        chatMessage {
            role = ChatRole.System
            content =
                "You are a poetic assistant, skilled in explaining complex programming concepts with creative flair."
        },
        chatMessage {
            role = ChatRole.User
            content = "Compose a poem that explains the concept of OOP in programming."
        }
    )
    val request = chatCompletionRequest {
        model = modelId
        messages = chatMessages1
    }
    val response = openAI.chatCompletion(request)
    val message = response.choices.first().message

    println("\n> Generated content:")
    println(message.content)
}
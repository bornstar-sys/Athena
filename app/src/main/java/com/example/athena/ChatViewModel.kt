package com.example.athena

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatViewModel : ViewModel() {

    private val _messageList = MutableStateFlow<List<MessageModel>>(emptyList())
    val messageList: StateFlow<List<MessageModel>> = _messageList.asStateFlow()

    val generativeModel: GenerativeModel = GenerativeModel(
        modelName = "gemini-2.0-flash",
        apiKey = Constants.apikey
    )

    fun sendMessage(question: String) {
        viewModelScope.launch {
            try {
                // Add user message and typing indicator
                _messageList.value = _messageList.value + MessageModel(question, "user")
                _messageList.value = _messageList.value + MessageModel("Typing....", "model")

                // Make API call on background thread
                val response = withContext(Dispatchers.IO) {
                    val chat = generativeModel.startChat(
                        history = _messageList.value.map {
                            content(it.role) { text(it.message) }
                        }.toList()
                    )
                    chat.sendMessage(question)
                }

                // Remove typing indicator and add model response
                _messageList.value = _messageList.value.dropLast(1) // Replace removeLast
                val modelResponse = response.text?.toString() ?: "No response text"
                _messageList.value = _messageList.value + MessageModel(modelResponse, "model")
                Log.i("Response of Gemini", modelResponse)
            } catch (e: Exception) {
                // Remove typing indicator and add error message
                _messageList.value = _messageList.value.dropLast(1) // Replace removeLast
                _messageList.value = _messageList.value + MessageModel("Error: ${e.message}", "model")
                Log.e("ChatViewModel", "Error sending message: ${e.message}", e)
            }
        }
    }
}
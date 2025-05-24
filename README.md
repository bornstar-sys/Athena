Athena - AI-Powered Chatbot for Android

Athena is a modern Android chatbot application built with Kotlin and Jetpack Compose. It leverages Google’s Gemini 2.0 Flash generative AI model to provide intelligent, conversational responses to user queries. With a sleek, user-friendly interface, Athena allows users to engage in natural conversations, making it a versatile tool for answering questions, providing insights, or exploring AI capabilities.

Features
Conversational AI: Powered by Google’s Gemini 2.0 Flash model for dynamic and context-aware responses.
Modern UI: Built with Jetpack Compose, featuring a clean, responsive design with a semi-transparent background and customizable themes.
Real-Time Messaging: Displays user and AI messages in a scrollable chat interface with a typing indicator.
Error Handling: Gracefully manages API errors and displays them to the user.
Copyable Messages: Users can select and copy text from chat messages.

Requirements
Android: Android 7.0 (API level 24) or higher.
Development Environment:
Android Studio (latest stable version recommended).
Kotlin 1.9.0 or higher.
Gradle 8.0 or higher.

Dependencies:
Jetpack Compose for UI.
Google AI Client SDK for generative AI integration.
Coroutines and ViewModel for asynchronous operations and state management.
API Key: A valid Google AI API key for the Gemini 2.0 Flash model.


Installation
	1. Clone the Repository:
 									git clone https://github.com/bornstar-sys/Athena.git
									cd Athena
	2. Set Up Google AI API Key:
 									Obtain an API key from Google Cloud Console for the Gemini API.
									Replace the apikey value in Constants.kt with your API key:
				 					object Constants {
    							val apikey = "YOUR_API_KEY_HERE"
									}
	3. Open in Android Studio:
 									Import the project into Android Studio.
									Sync the project with Gradle to download dependencies.
	4. Build and Run:	
 									Connect an Android device or emulator.
									Build and run the app using Android Studio (Run > Run 'app').


Usage

Launch the Athena app on your Android device.
Type a message or question in the input field at the bottom of the screen.
Press the Send button to submit your message.
Athena will display a "Typing..." indicator while processing, followed by the AI’s response.
Scroll through the chat history to view previous messages.
Long-press on a message to select and copy its text.

Example

User Input: "What is the capital of France?"
Athena Response: "The capital of France is Paris."

Project Structure

MessageModel.kt: Data class for representing chat messages with a message string and role (user or model).
MainActivity.kt: Entry point of the app, initializing Jetpack Compose and the ChatViewModel.
ChatViewModel.kt: Manages chat state and communicates with the Gemini API to send/receive messages.
Constants.kt: Stores the API key for the Gemini model.
ChatPage.kt: Composable UI components for the chat interface, including message display, input field, and header.

Dependencies
Add the following to your build.gradle (module-level) for the required libraries:
	dependencies {
	    implementation "androidx.activity:activity-compose:1.9.0"
	    implementation "androidx.compose.material3:material3:1.2.0"
	    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0"
	    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"
	    implementation "com.google.ai.client:generativeai:0.5.0" // Adjust version as needed
	}

Contact
For questions or feedback, contact the maintainer via GitHub Issues or reach out to bornstar-sys.

Acknowledgments
Built with Jetpack Compose for modern Android UI.
Powered by Google Gemini API for generative AI capabilities.


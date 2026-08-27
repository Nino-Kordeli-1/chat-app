package com.chatapp.chat.screen.chat_conversation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chatapp.navigation.navigator.localNavigator

@Composable
fun ChatConversationScreen(chatId: String) {
    val navigator = localNavigator()

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Chat Conversation: $chatId")

        OutlinedButton(onClick = navigator::pop) {
            Text("Back")
        }
    }
}
package com.chatapp.chat.screen.chat_list.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chatapp.chat.navigation.routes.ChatRoute
import com.chatapp.navigation.navigator.localNavigator

@Composable
fun ChatListScreen() {
    val navigator = localNavigator()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Chat List")

        Button(onClick = { navigator.push(ChatRoute.ChatConversation(chatId = "1")) }) {
            Text("Open a Chat")
        }
    }
}
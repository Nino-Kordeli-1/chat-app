package com.chatapp.navigation.entries.chat

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.navigation.chat.routes.chat.ChatRoute

fun EntryProviderScope<NavKey>.chatEntry() {
    entry<ChatRoute.ChatList>{/*ChatListScreen*/}
   /* entry<ChatRoute.ChatConversation> { route ->
        ChatConversationScreen(chatId = route.chatId)
    } temporary */
}
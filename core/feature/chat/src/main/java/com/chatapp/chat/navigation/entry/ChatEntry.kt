package com.chatapp.chat.navigation.entry

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.chat.navigation.routes.ChatRoute

fun EntryProviderScope<NavKey>.chatEntry() {
    entry<ChatRoute.ChatList> {/*ChatListScreen*/ }
    entry<ChatRoute.ChatConversation> {/* route ->
        ChatConversationScreen(chatId = route.chatId)
    } temporary */
    }
}
package com.chatapp.chat.navigation.routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface ChatRoute : NavKey {
    @Serializable
    @SerialName("ChatList")
    data object ChatList : ChatRoute

    @Serializable
    @SerialName("ChatConversation")
    data class ChatConversation(val chatId: String) : ChatRoute
}
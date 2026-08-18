package com.chatapp.chat.navigation.routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class ChatRoute : NavKey {
    @Serializable
    data object ChatList : ChatRoute()

    @Serializable
    data object ChatConversation : ChatRoute()
}
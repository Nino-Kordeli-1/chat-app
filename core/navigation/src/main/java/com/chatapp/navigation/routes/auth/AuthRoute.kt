package com.chatapp.navigation.routes.auth

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class AuthRoute : NavKey {
    @Serializable
    data object Registration : AuthRoute()

    @Serializable
    data object Login: AuthRoute()

}
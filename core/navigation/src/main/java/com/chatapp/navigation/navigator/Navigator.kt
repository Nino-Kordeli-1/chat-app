package com.chatapp.navigation.navigator

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation3.runtime.NavKey

interface Navigator {
    fun navigateTo(route: NavKey)
    fun clearAndNavigate(route: NavKey)
    fun navigateBack()
}

val localNavigator = staticCompositionLocalOf<Navigator> {
    error("No Navigator provided")
}
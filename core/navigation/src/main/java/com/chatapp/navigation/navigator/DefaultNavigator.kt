package com.chatapp.navigation.navigator

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class DefaultNavigator(
    private val backStack: NavBackStack<NavKey>
) : Navigator {

    override fun navigateTo(route: NavKey) {
        if (backStack.lastOrNull() != route) {
            backStack.add(route)
        }
    }

    override fun clearAndNavigate(route: NavKey) {
        backStack.clear()
        backStack.add(route)
    }

    override fun navigateBack() {
        if (backStack.size > 1) {
            backStack.removeLastOrNull()
        }
    }
}
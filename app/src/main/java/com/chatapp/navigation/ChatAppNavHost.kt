package com.chatapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.chatapp.navigation.navigator.DefaultNavigator
import com.chatapp.navigation.navigator.localNavigator
import com.chatapp.navigation.routes.home.HomeRoute

@Composable
fun ChatAppNavHost(
    modifier: Modifier = Modifier,
    entryProvider: (NavKey) -> NavEntry<NavKey>
) {
    val backStack = rememberNavBackStack(HomeRoute.Home)

    val navigator = remember(backStack) {
        DefaultNavigator(backStack)
    }

    CompositionLocalProvider(localNavigator provides navigator) {
        NavDisplay(
            backStack = backStack,
            modifier = modifier,
            onBack = navigator::navigateBack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider
        )
    }
}
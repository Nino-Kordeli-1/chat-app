package com.chatapp.navigation.entries.chat_feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.chatapp.navigation.chat.routes.chat.ChatRoute
import com.chatapp.navigation.entries.chat.chatEntry
import com.chatapp.navigation.navigator.DefaultNavigator
import com.chatapp.navigation.navigator.LocalFlowNavigator

@Composable
fun ChatFeatureEntry() {
    val backStack = rememberNavBackStack(ChatRoute.ChatList)

    val navigator = remember(backStack) {
        DefaultNavigator(backStack)
    }

    CompositionLocalProvider(LocalFlowNavigator provides navigator) {
        NavDisplay(
            backStack = backStack,
            onBack = navigator::navigateBack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                chatEntry()
            }
        )
    }
}
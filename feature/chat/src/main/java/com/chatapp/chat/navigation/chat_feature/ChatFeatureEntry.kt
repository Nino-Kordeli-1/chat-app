package com.chatapp.chat.navigation.chat_feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.chatapp.chat.navigation.routes.ChatRoute
import com.chatapp.chat.navigation.entry.chatEntry
import com.chatapp.navigation.navigator.DefaultNavigator
import com.chatapp.navigation.navigator.LocalFlowNavigator

@Composable
fun ChatFeatureEntry(
    onRootBack: () -> Unit
) {
    val backStack = rememberNavBackStack(ChatRoute.ChatList)

    val navigator = remember(backStack) {
        DefaultNavigator(backStack)
    }

    CompositionLocalProvider(LocalFlowNavigator provides navigator) {
        NavDisplay(
            backStack = backStack,
            onBack = {
                if (backStack.size > 1) {
                    navigator.pop()
                }else{
                    onRootBack()
                }
            },
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
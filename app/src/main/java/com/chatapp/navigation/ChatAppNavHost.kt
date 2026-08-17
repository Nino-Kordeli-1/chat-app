package com.chatapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.chatapp.navigation.entries.auth_feature.AuthFeatureEntry
import com.chatapp.navigation.entries.chat_feature.ChatFeatureEntry
import com.chatapp.navigation.keys.AuthFeatureKey
import com.chatapp.navigation.keys.ChatFeatureKey
import com.chatapp.navigation.navigator.DefaultNavigator
import com.chatapp.navigation.navigator.localNavigator

@Composable
fun ChatAppNavHost(
    modifier: Modifier = Modifier,
    onExit: () -> Unit
) {
    val globalBackStack = rememberNavBackStack(AuthFeatureKey)

    val globalNavigator = remember(globalBackStack) {
        DefaultNavigator(globalBackStack)
    }

    CompositionLocalProvider(localNavigator provides globalNavigator) {
        NavDisplay(
            backStack = globalBackStack,
            modifier = modifier,
            onBack = {
                if (globalBackStack.size > 1) {
                    globalNavigator.navigateBack()
                } else {
                    onExit()
                }
            },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                entry<AuthFeatureKey> { AuthFeatureEntry() }
                entry<ChatFeatureKey> { ChatFeatureEntry() }
            }
        )
    }
}
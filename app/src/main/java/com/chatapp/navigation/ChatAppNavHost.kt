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
import com.chatapp.authentication.navigation.auth_feature.AuthFeatureEntry
import com.chatapp.chat.navigation.chat_feature.ChatFeatureEntry
import com.chatapp.navigation.keys.AuthFeatureKey
import com.chatapp.navigation.keys.ChatFeatureKey
import com.chatapp.navigation.navigator.DefaultNavigator
import com.chatapp.navigation.navigator.LocalGlobalNavigator

@Composable
fun ChatAppNavHost(
    modifier: Modifier = Modifier,
    onExit: () -> Unit
) {
    val globalBackStack = rememberNavBackStack(AuthFeatureKey)

    val globalNavigator = remember(globalBackStack) {
        DefaultNavigator(globalBackStack)
    }

    CompositionLocalProvider(LocalGlobalNavigator provides globalNavigator) {
        NavDisplay(
            backStack = globalBackStack,
            modifier = modifier,
            onBack = {
                if (globalBackStack.size > 1) {
                    globalNavigator.pop()
                } else {
                    onExit()
                }
            },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                entry<AuthFeatureKey> {
                    AuthFeatureEntry(
                        onRootBack = {
                            if (globalBackStack.size > 1) {
                                globalNavigator.pop()
                            } else {
                                onExit()
                            }
                        }
                    )
                }
                entry<ChatFeatureKey> {
                    ChatFeatureEntry(
                        onRootBack = {
                            if (globalBackStack.size > 1) {
                                globalNavigator.pop()
                            } else {
                                onExit()
                            }
                        }
                    )
                }
            }
        )
    }
}
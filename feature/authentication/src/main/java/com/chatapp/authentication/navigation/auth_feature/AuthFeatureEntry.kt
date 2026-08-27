package com.chatapp.authentication.navigation.auth_feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.chatapp.authentication.navigation.entry.authEntry
import com.chatapp.authentication.navigation.entry.biometricsEntry
import com.chatapp.authentication.navigation.entry.homeEntry
import com.chatapp.authentication.navigation.entry.verificationEntry
import com.chatapp.authentication.navigation.routes.home.HomeRoute
import com.chatapp.navigation.navigator.DefaultNavigator
import com.chatapp.navigation.navigator.LocalFlowNavigator

@Composable
fun AuthFeatureEntry(
    onRootBack: () -> Unit
) {
    val backStack = rememberNavBackStack(HomeRoute.Home)

    val navigator = remember(backStack) {
        DefaultNavigator(backStack)
    }

    CompositionLocalProvider(LocalFlowNavigator provides navigator) {
        NavDisplay(
            backStack = backStack,
            onBack = {
                if (backStack.size > 1) {
                    navigator.pop()
                } else {
                    onRootBack()
                }
            },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                homeEntry()
                authEntry()
                verificationEntry()
                biometricsEntry()
            }
        )
    }
}
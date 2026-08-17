package com.chatapp.navigation.entries.auth_feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.chatapp.navigation.auth.routes.auth.AuthRoute
import com.chatapp.navigation.entries.auth.authEntry
import com.chatapp.navigation.entries.biometrics.biometricsEntry
import com.chatapp.navigation.entries.home.homeEntry
import com.chatapp.navigation.entries.verification.verificationEntry
import com.chatapp.navigation.navigator.DefaultNavigator
import com.chatapp.navigation.navigator.LocalFlowNavigator

@Composable
fun AuthFeatureEntry() {
    val backStack = rememberNavBackStack(AuthRoute.Registration)

    val navigator = remember(backStack) {
        DefaultNavigator(backStack)
    }

    CompositionLocalProvider(LocalFlowNavigator provides navigator) {
        NavDisplay(
            backStack = backStack,
            onBack = {
                if (backStack.size > 1) {
                    navigator.navigateBack()
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
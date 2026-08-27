package com.chatapp.authentication.navigation.entry

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.authentication.navigation.routes.auth.AuthRoute
import com.chatapp.authentication.screen.login.screen.LoginScreen
import com.chatapp.authentication.screen.registration.screen.RegistrationScreen

fun EntryProviderScope<NavKey>.authEntry() {
    entry<AuthRoute.Registration> { RegistrationScreen() }
    entry<AuthRoute.Login> { LoginScreen() }
}
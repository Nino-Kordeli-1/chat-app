package com.chatapp.navigation.entries.auth

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.navigation.routes.auth.AuthRoute

fun EntryProviderScope<NavKey>.authEntry() {
    entry<AuthRoute.Registration>{/*RegistrationScreen()*/}
    entry<AuthRoute.Login>{/*LoginScreen()*/}
}
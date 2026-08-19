package com.chatapp.authentication.navigation.entry

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.authentication.navigation.routes.home.HomeRoute

fun EntryProviderScope<NavKey>.homeEntry() {
    entry<HomeRoute.Home> { /*HomeScreen()*/ }
}
package com.chatapp.navigation.entries.home

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.navigation.routes.home.HomeRoute

fun EntryProviderScope<NavKey>.homeEntries() {
    entry<HomeRoute.Home> { /*HomeScreen()*/ }
}
package com.chatapp.authentication.navigation.entry

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.authentication.navigation.routes.biometrics.BiometricsRoute

fun EntryProviderScope<NavKey>.biometricsEntry() {
    entry<BiometricsRoute.EnableBiometric>{ /*BiometricsScreen()*/ }
}
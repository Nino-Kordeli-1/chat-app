package com.chatapp.navigation.entries.biometrics

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.navigation.routes.biometrics.BiometricsRoute

fun EntryProviderScope<NavKey>.biometricsEntry() {
    entry<BiometricsRoute.EnableBiometric>{ /*BiometricsScreen()*/ }
}
package com.chatapp.navigation.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf

val LocalGlobalNavigator = staticCompositionLocalOf<Navigator?> { null }

val LocalFlowNavigator = compositionLocalOf<Navigator?> { null }

@Composable
fun globalNavigator() = LocalGlobalNavigator.current

@Composable
fun localNavigator() = LocalFlowNavigator.current

@Composable
fun requireGlobalNavigator(): Navigator =
    globalNavigator() ?: error("Global navigator is not available")

@Composable
fun requireLocalNavigator(): Navigator =
    localNavigator() ?: error("Local navigator is not available")
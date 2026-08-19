package com.chatapp.navigation.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf

val LocalGlobalNavigator = staticCompositionLocalOf<Navigator?> { null }

val LocalFlowNavigator = compositionLocalOf<Navigator?> { null }

@Composable
fun globalNavigator(): Navigator? = LocalGlobalNavigator.current

@Composable
fun localNavigator(): Navigator? = LocalFlowNavigator.current
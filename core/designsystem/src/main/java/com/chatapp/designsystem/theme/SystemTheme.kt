package com.chatapp.designsystem.theme

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun SystemTheme(
    lightIcons: Boolean = false
) {
    val view = LocalView.current

    DisposableEffect(lightIcons) {
        val window = (view.context as Activity).window
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        insetsController.isAppearanceLightStatusBars = lightIcons
        insetsController.isAppearanceLightNavigationBars = lightIcons

        onDispose { }
    }
}
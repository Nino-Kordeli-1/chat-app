package com.chatapp.designsystem.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier

private val LocalChatAppColors = staticCompositionLocalOf { DarkColorScheme }
private val LocalChatAppTypography = staticCompositionLocalOf { ChatAppTypography }

object ChatAppTheme {
    val colors: ChatAppColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalChatAppColors.current

    val typography: ChatAppTypographyScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalChatAppTypography.current
}

@Composable
fun ChatAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    SystemTheme(lightIcons = !darkTheme)

    CompositionLocalProvider(
        LocalChatAppColors provides colorScheme,
        LocalChatAppTypography provides ChatAppTypography
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorScheme.background)
        ) {
            content()
        }
    }
}
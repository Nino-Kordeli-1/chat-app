package com.chatapp.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

private val Purple500 = Color(0xFF9F60FF)
private val Purple200 = Color(0xFFDAC2FF)
private val Gold300 = Color(0xFFF7CE7F)
private val Gray900 = Color(0xFF191919)
private val Gray500 = Color(0xFFC7C7C7)
private val Gray100 = Color(0xFFF1F1F1)
private val White = Color(0xFFFFFFFF)
private val DeepNavy900 = Color(0xFF160039)
private val DeepNavy700 = Color(0xFF2E0072)
private val RedError = Color(0xFFFF0000)

@Immutable
data class ChatAppColorScheme(
    val isDark: Boolean,
    val background: Color,
    val surface: Color,
    val surfaceVariant: Color,
    val primary: Color,
    val primaryContainer: Color,
    val outline: Color,
    val outlineVariant: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textOnPrimary: Color,
    val error: Color
)

val DarkColorScheme = ChatAppColorScheme(
    isDark = true,
    background = DeepNavy900,
    surface = DeepNavy700,
    surfaceVariant = Gray100,
    primary = Purple500,
    primaryContainer = Purple200,
    outline = Purple500,
    outlineVariant = Gold300,
    textPrimary = White,
    textSecondary = Gray500,
    textOnPrimary = White,
    error = RedError,
)

val LightColorScheme = ChatAppColorScheme(
    isDark = false,
    background = White,
    surface = Gray100,
    surfaceVariant = Gray100,
    primary = Purple500,
    primaryContainer = Purple200,
    outline = Purple500,
    outlineVariant = Gold300,
    textPrimary = Gray900,
    textSecondary = Gray500,
    textOnPrimary = White,
    error = RedError,
)
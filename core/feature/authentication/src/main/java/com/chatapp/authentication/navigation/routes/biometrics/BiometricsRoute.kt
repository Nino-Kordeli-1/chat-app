package com.chatapp.authentication.navigation.routes.biometrics

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class BiometricsRoute : NavKey {
    @Serializable
    data object EnableBiometric : BiometricsRoute()
}
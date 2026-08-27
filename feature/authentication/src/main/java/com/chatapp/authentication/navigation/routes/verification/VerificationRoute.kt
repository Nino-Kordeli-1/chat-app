package com.chatapp.authentication.navigation.routes.verification

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class VerificationRoute: NavKey {
    @Serializable
    data object FaceScan: VerificationRoute()
    @Serializable
    data object FaceConfirmed: VerificationRoute()
    @Serializable
    data object FaceFailed: VerificationRoute()
}
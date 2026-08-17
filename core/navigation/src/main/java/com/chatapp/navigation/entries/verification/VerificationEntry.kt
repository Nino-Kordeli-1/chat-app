package com.chatapp.navigation.entries.verification

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.navigation.auth.routes.verification.VerificationRoute

fun EntryProviderScope<NavKey>.verificationEntry() {
    entry<VerificationRoute.FaceScan> {/*FaceScanScreen*/ }
    entry<VerificationRoute.FaceFailed> {/*FaceFailedScreen*/ }
    entry<VerificationRoute.FaceConfirmed> {/*FaceConfirmedScreen*/ }
}
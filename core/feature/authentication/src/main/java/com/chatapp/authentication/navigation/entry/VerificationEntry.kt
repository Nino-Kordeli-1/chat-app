package com.chatapp.authentication.navigation.entry

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.authentication.navigation.routes.verification.VerificationRoute

fun EntryProviderScope<NavKey>.verificationEntry() {
    entry<VerificationRoute.FaceScan> {/*FaceScanScreen*/ }
    entry<VerificationRoute.FaceFailed> {/*FaceFailedScreen*/ }
    entry<VerificationRoute.FaceConfirmed> {/*FaceConfirmedScreen*/ }
}
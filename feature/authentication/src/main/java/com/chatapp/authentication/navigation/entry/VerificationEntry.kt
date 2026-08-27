package com.chatapp.authentication.navigation.entry

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.chatapp.authentication.navigation.routes.verification.VerificationRoute
import com.chatapp.authentication.screen.face_scan.screen.FaceFailedScreen
import com.chatapp.authentication.screen.face_scan.screen.FaceScanScreen
import com.chatapp.verification.FaceConfirmedScreen

fun EntryProviderScope<NavKey>.verificationEntry() {
    entry<VerificationRoute.FaceScan> { FaceScanScreen() }
    entry<VerificationRoute.FaceFailed> { FaceFailedScreen() }
    entry<VerificationRoute.FaceConfirmed> { FaceConfirmedScreen() }
}
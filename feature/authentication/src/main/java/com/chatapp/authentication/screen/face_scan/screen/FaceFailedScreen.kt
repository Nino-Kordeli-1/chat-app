package com.chatapp.authentication.screen.face_scan.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chatapp.authentication.navigation.routes.verification.VerificationRoute
import com.chatapp.navigation.navigator.localNavigator

@Composable
fun FaceFailedScreen() {
    val navigator = localNavigator()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Face Failed")

        Button(onClick = { navigator.push(VerificationRoute.FaceScan) }) {
            Text("Retry")
        }
    }
}

@Preview
@Composable
fun FaceFailedScreenPreview() {
    FaceFailedScreen()
}
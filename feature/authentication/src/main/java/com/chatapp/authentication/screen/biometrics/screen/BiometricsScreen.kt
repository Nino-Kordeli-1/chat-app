package com.chatapp.authentication.screen.biometrics.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chatapp.navigation.keys.ChatFeatureKey
import com.chatapp.navigation.navigator.globalNavigator

@Composable
fun BiometricsScreen() {
    val globalNav = globalNavigator()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Enable Biometric Login?")

        Button(onClick = { globalNav.replaceAll(ChatFeatureKey) }) {
            Text("Enable")
        }
        OutlinedButton(onClick = { globalNav.replaceAll(ChatFeatureKey) }) {
            Text("Not Now")
        }
    }
}

@Preview
@Composable
fun BiometricsScreenPreview() {
    BiometricsScreen()
}
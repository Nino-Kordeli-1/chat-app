package com.chatapp.authentication.screen.login.screen

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
import com.chatapp.navigation.navigator.localNavigator

@Composable
fun LoginScreen() {
    val localNavigator = localNavigator()
    val globalNavigator = globalNavigator()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Login")

        Button(onClick = { globalNavigator.replaceAll(ChatFeatureKey) }) {
            Text("Log in")
        }
        OutlinedButton(onClick = localNavigator::pop) {
            Text("Back")
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginScreen()
}
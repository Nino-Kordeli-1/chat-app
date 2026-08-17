package com.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import com.chatapp.designsystem.theme.ChatAppTheme
import com.chatapp.navigation.ChatAppNavHost
import com.chatapp.navigation.entries.auth.authEntry
import com.chatapp.navigation.entries.biometrics.biometricsEntry
import com.chatapp.navigation.entries.home.homeEntry
import com.chatapp.navigation.entries.verification.verificationEntry

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatAppTheme {
                ChatAppNavHost(
                    modifier = Modifier.fillMaxSize(),
                    entryProvider = entryProvider {
                        homeEntry()
                        authEntry()
                        verificationEntry()
                        biometricsEntry()
                    }
                )
            }
        }
    }
}
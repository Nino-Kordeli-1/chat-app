package com.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.chatapp.designsystem.theme.ChatAppTheme
import com.chatapp.navigation.ChatAppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatAppTheme {
                ChatAppNavHost(
                    modifier = Modifier.fillMaxSize(),
                    onExit = ::finishAffinity
                )
            }
        }
    }
}
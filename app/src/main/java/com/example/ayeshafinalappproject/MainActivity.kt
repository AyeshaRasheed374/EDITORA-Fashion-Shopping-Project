package com.example.ayeshafinalappproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ayeshafinalappproject.ui.AppNavigation
import com.example.ayeshafinalappproject.ui.theme.AyeshaFinalAppProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AyeshaFinalAppProjectTheme {
                AppNavigation()
            }
        }
    }
}

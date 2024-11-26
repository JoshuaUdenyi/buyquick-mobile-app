package com.udenyijoshua.buyquick

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.udenyijoshua.buyquick.ui.theme.BuyQuickTheme
import com.udenyijoshua.buyquick.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val authState by authViewModel.authState.collectAsState()

            // Navigate to AuthFlow if not authenticated
            LaunchedEffect(authState) {
                if (authState == null) {
                    // Start AuthFlow activity and finish the current one
                    startActivity(Intent(this@MainActivity, AuthFlow::class.java))
                    finish()
                }
            }

            // If authenticated, show the main application
            if (authState != null) {
                BuyQuickTheme {
                    Application()
                }
            }
        }
    }
}



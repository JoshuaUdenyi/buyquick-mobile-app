package com.udenyijoshua.buyquick

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.udenyijoshua.buyquick.ui.theme.BuyQuickTheme
import com.udenyijoshua.buyquick.viewmodel.AuthState
import com.udenyijoshua.buyquick.viewmodel.AuthViewModel

class LauncherActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuyQuickTheme {
                LauncherScreen(authViewModel = authViewModel)
            }
        }
    }

    @Composable
    fun LauncherScreen(authViewModel: AuthViewModel) {
        // Collect auth state as a Compose state
        val authState by authViewModel.authState.collectAsState()

        // Handle side effects for navigation
        LaunchedEffect(authState) {
            when (authState) {
                is AuthState.Authenticated -> navigateToApp()  // Navigate to the main app activity
                is AuthState.Unauthenticated -> navigateToAuthFlow()  // Navigate to the auth flow
                is AuthState.Loading -> {} // Optionally show a loading screen
                is AuthState.Error -> showError((authState as AuthState.Error).message) // Show error
            }
        }

        // Optionally render a loading indicator while determining authentication state
        if (authState is AuthState.Loading) {
            LoadingIndicator()
        }
    }

    private fun navigateToApp() {
        startActivity(Intent(this, MainActivity::class.java)) // Navigate to MainActivity or your main app screen
        finish()  // Finish the LauncherActivity to prevent it from being in the back stack
    }

    private fun navigateToAuthFlow() {
        startActivity(Intent(this, AuthFlow::class.java))  // Navigate to the AuthFlow for authentication
        finish()  // Finish the LauncherActivity to prevent it from being in the back stack
    }

    private fun showError(message: String) {
        // Show an error screen with the message
        setContent {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: $message")
            }
        }
    }

    @Composable
    fun LoadingIndicator() {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

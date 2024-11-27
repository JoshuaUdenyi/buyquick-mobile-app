package com.udenyijoshua.buyquick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.udenyijoshua.buyquick.navigation.AuthScreen
import com.udenyijoshua.buyquick.screens.authscreen.Login
import com.udenyijoshua.buyquick.screens.authscreen.Signup
import com.udenyijoshua.buyquick.viewmodel.AuthViewModel

class AuthFlow : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AuthenticationFlow(authViewModel = authViewModel)
        }
    }

    private fun showError(message: String) {
        setContent {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: $message")
            }
        }
    }
}

@Composable
fun AuthenticationFlow(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    AuthNavHost(navController, authViewModel)
}

@Composable
fun AuthNavHost(navController: NavHostController, authViewModel: AuthViewModel) {
    NavHost(
        navController = navController,
        startDestination = AuthScreen.Login.route
    ) {
        composable(AuthScreen.Login.route) {
            Login(
                authViewModel = authViewModel,
                onNavigateToSignUp = { navController.navigate(AuthScreen.SignUp.route)  }
            )
        }
        composable(AuthScreen.SignUp.route) {
            Signup(authViewModel = authViewModel)  // Ensure this is properly connected to your ViewModel or any logic you want
        }
    }
}

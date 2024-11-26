package com.udenyijoshua.buyquick

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
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
            Authentication(authViewModel = authViewModel)
        }
    }
}

@Composable
fun Authentication(authViewModel: AuthViewModel) {
    val authState by authViewModel.authState.collectAsState()
    val context = LocalContext.current

    // Handle navigation to MainActivity after successful authentication
    LaunchedEffect(authState) {
        if (authState != null) {
            // Navigate to MainActivity
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            (context as? ComponentActivity)?.finish()
        }
    }

    // If not authenticated, show the authentication screens
    if (authState == null) {
        val navController = rememberNavController()
        AuthNavHost(navController, authViewModel)
    }
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

package com.udenyijoshua.buyquick.navigation

sealed class AuthScreen(val route: String) {
    data object SignUp : AuthScreen("signup")
    data object Login : AuthScreen("login")
}

//Declare more screens here
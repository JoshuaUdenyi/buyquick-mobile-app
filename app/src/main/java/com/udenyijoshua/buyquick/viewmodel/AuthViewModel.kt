package com.udenyijoshua.buyquick.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


sealed class AuthState{
    data object Authenticated: AuthState()
    data object Unauthenticated: AuthState()
    data object Loading: AuthState()
    data class Error(val message: String): AuthState()
}

class AuthViewModel : ViewModel() {

    private val auth = Firebase.auth

    // StateFlow to track authentication state
    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState


    //Check Authentication State

    init {
        checkAuthenticationAtStartup()
    }

    private fun checkAuthenticationAtStartup() {
        if (auth.currentUser != null) {
            _authState.value = AuthState.Authenticated
        } else {
            _authState.value = AuthState.Unauthenticated
        }
    }


    // Create a new account with email and password
    fun createAccountWithEmail(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()){
            _authState.value = AuthState.Error("Email or Password can't be empty")
            return
        }

        viewModelScope.launch {
            _authState.value = AuthState.Loading
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = AuthState.Authenticated
                        val user = auth.currentUser
                    } else {
                        val errorMessage = task.exception?.message ?: "Something went wrong"
                        _authState.value = AuthState.Error(errorMessage)
                        Log.e("AuthViewModel", "createUserWithEmail:failure: $errorMessage")
                    }
                }
        }
    }

    // Log in an existing user with email and password
    fun loginWithEmailAndPassword(email: String, password: String) {

        if (email.isEmpty() || password.isEmpty()){
            _authState.value = AuthState.Error("Email or Password can't be empty")
            return
        }
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = AuthState.Authenticated
                        val user = auth.currentUser
                        Log.d("AuthViewModel", "Login successful: ${user?.email}")
                    } else {
                        _authState.value = AuthState.Error(task.exception?.message?: "Something went wrong")
                    }
                }
        }
    }

    fun signOut(){
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }
}

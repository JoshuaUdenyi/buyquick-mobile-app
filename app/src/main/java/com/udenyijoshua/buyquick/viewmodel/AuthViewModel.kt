package com.udenyijoshua.buyquick.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val auth = Firebase.auth

    // StateFlow to track authentication state
    private val _authState = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val authState: StateFlow<FirebaseUser?> = _authState

    // Create a new account with email and password
    fun createAccountWithEmail(email: String, password: String) {
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("AuthViewModel", "createUserWithEmail:success")
                        val user = auth.currentUser
                        _authState.value = user
                    } else {
                        val errorMessage = task.exception?.message ?: "Unknown error"
                        Log.e("AuthViewModel", "createUserWithEmail:failure: $errorMessage")
                    }
                }
        }
    }

    // Log in an existing user with email and password
    fun loginWithEmailAndPassword(email: String, password: String) {
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        _authState.value = user
                        Log.d("AuthViewModel", "Login successful: ${user?.email}")
                    } else {
                        val errorMessage = task.exception?.message ?: "Unknown error"
                        Log.e("AuthViewModel", "Login failed: $errorMessage")
                    }
                }
        }
    }
}

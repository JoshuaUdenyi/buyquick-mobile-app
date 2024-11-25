package com.udenyijoshua.buyquick.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch


interface AuthResponse {
    data object Success : AuthResponse
    data class Error(val message: String) : AuthResponse

}

class AuthViewModel() : ViewModel() {

    private val auth = Firebase.auth

    //Setup StateFlow
    private val _authState = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val authState: StateFlow<FirebaseUser?> = _authState

    //Stateflow for Toast
    private val _toastMessage = MutableStateFlow<String?>(null)
    val toastMessage: StateFlow<String?> get() = _toastMessage

    fun clearToastMessage() {
        _toastMessage.value = null
    }

    // Use .addOnCompleteListener(this) when using activity for navigating
    fun createAccountWithEmail(email: String, password: String): Flow<AuthResponse> = callbackFlow {
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    trySend(AuthResponse.Success)
                    val user = auth.currentUser
                } else {
//                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                    _toastMessage.value = "Authentication Failed"

                    trySend(AuthResponse.Error(message = task.exception?.message ?: ""))
                }
            }
        }
    }

    // Sign in User using Email and password
    fun loginWithEmailAndPassword(email: String, password: String): Flow<AuthResponse> = callbackFlow {
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    trySend(AuthResponse.Success)
                } else {
                    trySend(AuthResponse.Error(message = task.exception?.message ?: ""))
                }
            }
        }
    }
}
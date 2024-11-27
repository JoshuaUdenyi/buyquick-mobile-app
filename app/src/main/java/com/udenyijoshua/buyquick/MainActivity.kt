package com.udenyijoshua.buyquick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.udenyijoshua.buyquick.ui.theme.BuyQuickTheme
import com.udenyijoshua.buyquick.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BuyQuickTheme {
                Application(authViewModel)
            }
        }
    }

}
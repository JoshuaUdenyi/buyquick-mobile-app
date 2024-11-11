package com.udenyijoshua.buyquick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.udenyijoshua.buyquick.screens.Home
import com.udenyijoshua.buyquick.ui.theme.BuyQuickTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuyQuickTheme {
                Home()
            }
        }
    }
}


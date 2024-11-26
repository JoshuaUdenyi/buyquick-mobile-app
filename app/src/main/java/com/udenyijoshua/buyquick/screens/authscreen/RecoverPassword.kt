package com.udenyijoshua.buyquick.screens.authscreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.buyquick.R
import com.udenyijoshua.buyquick.screens.components.CustomTextField
import com.udenyijoshua.buyquick.screens.components.FilledCustomButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecoverPassword() {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {

                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White) // Background for the entire screen
        ) {

            // Top Section (e.g., Welcome Text or Banner)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Allocates 2 parts of the total space
                    .padding(start = 16.dp, end = 16.dp)

            ) {
                Text(
                    text = "Forgot password", style = TextStyle(
                        fontSize = 24.sp, color = Color.Black
                    )
                )
            }

            // Middle Section (Signup Forms)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    "Please, enter your email address. You will receive." +
                            "a link to create a new password via email"
                )

                Spacer(Modifier.height(16.dp))

//                CustomTextField(
//                    labelText = "Enter Email Address"
//                )

                Spacer(Modifier.height(70.dp))

                FilledCustomButton(
                    text = "SEND",
                    onSubmit = {},
                    true
                )

            }

        }

    }
}


package com.udenyijoshua.buyquick.screens.authscreen

import android.content.Intent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.buyquick.MainActivity
import com.udenyijoshua.buyquick.R
import com.udenyijoshua.buyquick.screens.components.CustomTextField
import com.udenyijoshua.buyquick.screens.components.FilledCustomButton
import com.udenyijoshua.buyquick.ui.theme.AppBackground
import com.udenyijoshua.buyquick.ui.theme.Metropolis
import com.udenyijoshua.buyquick.viewmodel.AuthState
import com.udenyijoshua.buyquick.viewmodel.AuthViewModel


inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit
): Modifier = composed {
    clickable(
        indication = null, // Removes the ripple effect
        interactionSource = remember { MutableInteractionSource() } // Tracks user interactions
    ) {
        onClick() // Executes the provided onClick lambda when clicked
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
    authViewModel: AuthViewModel,
    onNavigateToSignUp:() -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Observe the authentication state (success, failure, loading, etc.)
    val authState = authViewModel.authState.collectAsState()

//    // Handle navigation to MainActivity once the user is logged in

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> {
                Toast.makeText(context, "Authenticated!", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context, MainActivity::class.java))
                (context as? ComponentActivity)?.finish()
            }
            is AuthState.Loading -> {
                isLoading = true
            }
            is AuthState.Error -> {
                // Handle error state
            }
            else -> Unit
        }
    }


    Scaffold(
        topBar = {
            TopAppBar(navigationIcon = {
                IconButton(onClick = { /* Handle back navigation */ }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack, contentDescription = "Back"
                    )
                }
            }, title = {

            })
        },
        containerColor = AppBackground
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
                    .weight(1.5f) // Allocates 2 parts of the total space
                    .padding(16.dp) // Add padding if needed
            ) {
                Text(
                    text = "Login", style = TextStyle(
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Metropolis,
                        color = Color.Black
                    )
                )
            }

            // Middle Section (login Forms)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f) // Allocates 4 parts of the total space
                    .padding(horizontal = 16.dp) // Add horizontal padding
            ) {
                CustomTextField(
                    inputText = email,
                    onValueChange = { email = it },
                    labelText = "Email",
                )

                Spacer(Modifier.height(8.dp))

                CustomTextField(
                    inputText = password,
                    onValueChange = { password = it },
                    labelText = "Password",
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 14.dp, bottom = 28.dp)
                ) {
                    // Text with a font size of 14sp
                    BasicText(
                        text = "Don't have an account?",
                        style = TextStyle(
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.weight(1f).noRippleClickable {
                            onNavigateToSignUp()
                        }
                    )
                    Text(
                        text = "Forgot your password?",
                        fontSize = 14.sp,
                    )
                    Image(painter = painterResource(R.drawable.round_arrow),
                        contentDescription = "Arrow",
                        modifier = Modifier.clickable {
                            // Handle forgot password logic
                        })
                }

                // Submit Button (Login)
                FilledCustomButton(
                    "LOGIN", onSubmit = {
                        // Trigger login attempt using the ViewModel
                        authViewModel.loginWithEmailAndPassword(email, password)
                    },
                    isLoading = isLoading,
                    modifier = Modifier
                )
            }

            // Bottom Section (Social Signup, Always at the Bottom)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(23.dp) // Add padding for spacing
            ) {
                Text(
                    text = "Or login with social account", style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = Metropolis,
                        fontWeight = FontWeight.SemiBold
                    ), modifier = Modifier.align(Alignment.CenterHorizontally) // Centered
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Card(
                        onClick = {},
                        modifier = Modifier.size(94.dp, 64.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.elevatedCardElevation(2.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center // Center all content in the box
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.group),
                                contentDescription = "Google Icon",
                                tint = Color.Unspecified
                            )
                        }

                    }

                    Spacer(Modifier.width(16.dp))
                    Card(
                        onClick = {},
                        modifier = Modifier.size(94.dp, 64.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.elevatedCardElevation(2.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center // Center all content in the box
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.facebook_icon),
                                contentDescription = "Facebook Icon",
                                tint = Color.Unspecified
                            )
                        }

                    }

                }
            }
        }
    }
}


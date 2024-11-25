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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.buyquick.R
import com.udenyijoshua.buyquick.screens.components.CustomTextField
import com.udenyijoshua.buyquick.screens.components.FilledCustomButton
import com.udenyijoshua.buyquick.ui.theme.Metropolis


@Composable
fun Signup() {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
                .verticalScroll(rememberScrollState())// Background for the entire screen
        ) {
            // Top Section (e.g., Welcome Text or Banner)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.5f) // Allocates 2 parts of the total space
                    .padding(16.dp, top = 60.dp) // Add padding if needed
            ) {
                Text(
                    text = "Sign up", style = TextStyle(
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Metropolis,
                        color = Color.Black
                    )
                )
            }

            // Middle Section (Signup Forms)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f) // Allocates 4 parts of the total space
                    .padding(horizontal = 16.dp) // Add horizontal padding
            ) {
                CustomTextField(
                    labelText = "Name"
                ) // Replace with your fields
                Spacer(Modifier.height(8.dp))
                CustomTextField(
                    labelText = "Email"
                ) // Replace with your fields
                Spacer(Modifier.height(8.dp))
                CustomTextField(
                    labelText = "Password"
                ) // Replace with your fields

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth().padding(top = 14.dp, bottom = 28.dp)
                ) {
                    // Text with a font size of 14sp
                    Text(
                        text = "Already have an account?",
                        fontSize = 14.sp,
                    )

                    Image(
                        painter = painterResource(R.drawable.round_arrow),
                        contentDescription = "Arrow",
                        modifier = Modifier.clickable {

                        }
                    )

                }
                FilledCustomButton(
                    "SIGN UP"
                )

            }

            // Bottom Section (Social Signup, Always at the Bottom)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(23.dp) // Add padding for spacing
            ) {
                Text(
                    text = "Or sign up with social account", style = TextStyle(
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
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.group),
                                    contentDescription = "Google Icon",
                                    tint = Color.Unspecified
                                )
                            }
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

                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.facebook_icon),
                                    contentDescription = "Google Icon",
                                    tint = Color.Unspecified
                                )
                            }
                        }

                    }

                }
            }
        }

    }
}


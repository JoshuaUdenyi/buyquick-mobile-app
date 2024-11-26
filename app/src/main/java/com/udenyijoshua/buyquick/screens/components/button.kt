package com.udenyijoshua.buyquick.screens.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udenyijoshua.buyquick.ui.theme.BtnFilledRed

@Composable
fun FilledCustomButton(
    text: String,
    onSubmit: () -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            if (!isLoading) {
                Log.d("ButtonClick", "Button clicked")
                onSubmit()
            }
        },
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = BtnFilledRed),
        elevation = ButtonDefaults.buttonElevation(6.dp),
        enabled = !isLoading  // Disable button when loading
    ) {
        if (isLoading) {
            // Show CircularProgressIndicator while loading
            CircularProgressIndicator(modifier = Modifier.size(20.dp), color = Color.White)
        } else {
            // Show the button text when not loading
            Text(text = text)
        }
    }
}

@Composable
fun OutlinedCustomButton(
    text: String,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = { onSubmit() },
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black
        ),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Text(text = text)
    }
}

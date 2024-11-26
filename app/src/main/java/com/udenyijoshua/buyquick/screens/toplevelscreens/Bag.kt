package com.udenyijoshua.buyquick.screens.toplevelscreens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Bag() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Custom Graphics - Drawing a background circle
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            // Draw a semi-transparent circle in the background
            drawCircle(
                color = Color(0xFF6200EE).copy(alpha = 0.1f),
                radius = canvasWidth / 3f,
                center = Offset(canvasWidth / 2, canvasHeight / 2)
            )
        }

        // Text - Coming Soon
        Text(
            text = "Coming Soon",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color.Black
            )
        )
    }
}
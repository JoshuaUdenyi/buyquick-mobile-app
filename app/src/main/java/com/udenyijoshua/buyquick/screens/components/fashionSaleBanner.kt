package com.udenyijoshua.buyquick.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.buyquick.R
import com.udenyijoshua.buyquick.ui.theme.Metropolis

@Composable
fun FashionSaleBanner() {
    Box(
        modifier = Modifier.height(536.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentScale = ContentScale.Crop,
            contentDescription = "Fashion Banner",
            modifier = Modifier.fillMaxSize()
        )

        //TODO: added dimming effect at the bottom
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,  // Start with transparent at the top
                            Color.Black.copy(alpha = 0.8f)  // Gradually fade to black at the bottom
                        ),
                        startY = 0f,
                        endY = 1000f // You can adjust the gradient height to fit the image size
                    )
                )
        )

        Text(
            text = "Fashion\nsale",
            fontSize = 48.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 15.dp, top = 354.dp),
            textAlign = TextAlign.Start,
            lineHeight = 46.sp,
            fontFamily = Metropolis,
            fontWeight = FontWeight.Black
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 10.dp, top = 468.dp)
                .width(160.dp)
                .height(36.dp)
        ) {
            FilledCustomButton(text = "Check", onSubmit = {}, isLoading = true)
        }
    }
}

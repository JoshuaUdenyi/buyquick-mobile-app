package com.udenyijoshua.buyquick.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.buyquick.R
import com.udenyijoshua.buyquick.screens.components.FilledCustomButton
import com.udenyijoshua.buyquick.ui.theme.Metropolis

@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        FashionSaleBanner()
        ProductItem()

    }
}

@Composable
fun FashionSaleBanner() {
    Box(
        modifier = Modifier
            .height(536.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentScale = ContentScale.Crop,
            contentDescription = "Fashion Banner",
            modifier = Modifier
                .fillMaxSize()
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
            FilledCustomButton(text = "Check")
        }
    }
}


@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(260.dp)
    ) {
        Column(
            modifier = modifier
        ) {
            Box(
                modifier = Modifier
                    .width(148.dp)
                    .height(184.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.LightGray) // Replace with your color `ProductBackGroundlightGray`
            ) {
                // Image(
                //     painter = painterResource(id = R.drawable.image),
                //     contentDescription = null,
                //     contentScale = ContentScale.Crop
                // )

                // New content you want to place at the end of the image box
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd) // Aligns to bottom right
                        .padding(8.dp) // Optional padding
                        .background(Color.Blue) // Example background for visibility
                        .size(24.dp) // Example size, adjust as needed
                ) {
                    Text(
                        text = "X",
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Text("Mango Boy")
            Text("T-Shirt Sailing")
            Text("10$")
        }
    }
}

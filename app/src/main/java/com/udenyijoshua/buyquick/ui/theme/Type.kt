package com.udenyijoshua.buyquick.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.udenyijoshua.buyquick.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val Metropolis = FontFamily(
    Font(R.font.metropolis_black, FontWeight.Black),
    Font(R.font.metropolis_bold, FontWeight.Bold),
    Font(R.font.metropolis_semibolditalic, FontWeight.SemiBold),
    Font(R.font.metropolis_thinitalic, FontWeight.Thin),
    Font(R.font.metropolis_thin, FontWeight.Thin)
)
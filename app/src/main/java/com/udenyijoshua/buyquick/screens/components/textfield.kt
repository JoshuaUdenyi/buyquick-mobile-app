package com.udenyijoshua.buyquick.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .fillMaxWidth() // Makes the Card fill the parent's width
            .defaultMinSize(minWidth = 343.dp, minHeight = 64.dp) // Ensures minimum dimensions
            .height(64.dp) // Enforces the height
    ) {
        BasicTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxSize() // Ensures the TextField fills the Card
                .background(Color.Transparent) // Keeps background consistent
        )
    }
}

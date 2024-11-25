package com.udenyijoshua.buyquick.screens.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    labelText: String = "", inputText: String = "", modifier: Modifier = Modifier
) {

    var input by remember {
        mutableStateOf("")
    }

    val labelPadding by animateDpAsState(
        targetValue = if (input.isEmpty()) 21.dp else 5.dp,
    )

    Card(
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minWidth = 343.dp, minHeight = 64.dp)
            .height(64.dp)
    ) {


        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(Color.White)
                .fillMaxSize()
        ) {
            // Label
            Text(
                text = labelText,
                color = if (input.isEmpty()) Color.Gray else Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = labelPadding)
            )

            // TextField
            BasicTextField(

                maxLines = 1,
                value = input,
                onValueChange = { input = it },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = if(input.isNotEmpty()) 20.sp else 14.sp
                ), decorationBox = { innerTextField ->
                    Box(
                        modifier = if(input.isNotEmpty()) Modifier.padding(top = 10.dp) else Modifier.padding(top = 0.dp)
                    ) {
                        innerTextField()
                    }
                }, modifier = Modifier.align(Alignment.CenterStart)
            )
        }

    }
}
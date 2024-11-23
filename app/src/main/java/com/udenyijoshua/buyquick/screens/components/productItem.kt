package com.udenyijoshua.buyquick.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.buyquick.R
import com.udenyijoshua.buyquick.ui.theme.Metropolis

@Composable
fun ProductItem(
    modifier: Modifier = Modifier
) {
    //TODO: setup all my custom font for seamless usage, make sure to add the correct fonts
    val metropolis = FontFamily(
        Font(R.font.metropolis_black, FontWeight.Normal),
        Font(R.font.metropolis_bold, FontWeight.Bold),
        Font(R.font.metropolis_semibolditalic, FontWeight.SemiBold),
        Font(R.font.metropolis_thin, FontWeight.Thin),
        Font(R.font.metropolis_thinitalic, FontWeight.ExtraLight)
    )

    //TODO: setup the variables for rating stars
    val density = LocalDensity.current.density
    val starSize = (5f * density).dp
    val starSpacing = (0.5f * density).dp

    //TODO: first item
    Column(
        horizontalAlignment = Alignment.Start, modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .width(150.dp)
    ) {
        //TODO: the first container that house the "-20%", the girl image and the favorite card
        Column(
//            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy((-30).dp) // Ensures it overlaps the content,
        ) {
            Box(
                modifier = Modifier
                    .width(148.dp)
                    .height(184.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
            ) {
                //TODO: image for the person
                Image(
                    painter = painterResource(id = R.drawable.girl), // Replace with your image resource
                    contentDescription = "girl in the box",
                    contentScale = ContentScale.Crop, // Adjusts how the image fits
                    modifier = Modifier.fillMaxSize() // Fills the entire Box
                )

                //TODO: Box for the -20% off
                Box(
                    modifier = Modifier
                        .padding(8.dp) // Apply padding last
                        .width(40.dp)
                        .height(25.dp) // Set size first
                        .align(Alignment.TopStart) // Position the element
                        .clip(RoundedCornerShape(16.dp)) // Apply rounded corners
                        .background(Color.Red) // Set background color
                ) {
                    Text(
                        text = "-20%",
                        color = Color.White,
                        fontSize = 11.sp,
                        fontFamily = metropolis,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            //TODO: Overlapping Card at the bottom right
            Card(
                modifier = Modifier
                    .size(30.dp)
                    .offset(y = 13.dp) // Moves the Card 13dp downwards to overlap
                    .align(Alignment.End) // Aligns it to the bottom end of the parent
                , shape = RoundedCornerShape(16.dp), // Rounded corners
                elevation = CardDefaults.cardElevation(2.dp) //elevation shadow
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.favorite), // Replace with your image resource
                        contentDescription = "favorite",
                        contentScale = ContentScale.Crop, // Adjusts how the image fits
                        modifier = Modifier.align(Alignment.Center) // Centers the icon
                    )
                }
            }
        }

        //TODO: the row for the rating star and the "(10)"
        Row(
            modifier = Modifier.padding(top = 3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.selectableGroup(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 1..5) {
                    val isSelected = i <= 5
                    val icon = if (isSelected) Icons.Filled.Star else Icons.Default.Star
                    val iconTintColor = if (isSelected) Color(0xFFFFC700) else Color(0x20FFFFFF)
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconTintColor,
                        modifier = Modifier
                            .selectable(selected = isSelected, onClick = {
//                                    onRatingChanged(i.toFloat())
                            })
                            .width(starSize)
                            .height(starSize)
                    )

                    if (i < 5) {
                        Spacer(modifier = Modifier.width(starSpacing))
                    }
                }
            }
            Box(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    fontSize = 10.sp,
                    fontFamily = Metropolis,
                    fontWeight = FontWeight.Normal,
                    text = "(10)"
                )
            }

        }

        //TODO: Other text and their properties
        Text(
            modifier = Modifier.padding(top = 3.dp),
            text = "Dorothy Perkins",
            fontSize = 10.sp,
            fontFamily = Metropolis,
            fontWeight = FontWeight.Normal
        )

        Text(
            modifier = Modifier.padding(top = 3.dp),
            text = "Evening Dress",
            fontSize = 16.sp,
            fontFamily = Metropolis,
            fontWeight = FontWeight.SemiBold
        )

        Row(
            modifier = Modifier.padding(top = 3.dp)
        ) {
            Text(
                text = "15$",
                fontFamily = Metropolis,
                textDecoration = TextDecoration.LineThrough,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF9B9B9B)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "12$",
                fontFamily = Metropolis,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFDB3022)
            )
        }
    }

}

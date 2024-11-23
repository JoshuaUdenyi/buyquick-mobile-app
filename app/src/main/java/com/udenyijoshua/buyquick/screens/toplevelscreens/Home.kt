package com.udenyijoshua.buyquick.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.buyquick.R
import com.udenyijoshua.buyquick.screens.components.FashionSaleBanner
import com.udenyijoshua.buyquick.screens.components.FilledCustomButton
import com.udenyijoshua.buyquick.screens.components.ProductItem
import com.udenyijoshua.buyquick.ui.theme.Metropolis

@Composable
fun Home(modifier: Modifier = Modifier) {
    LazyColumn {
        item {
            FashionSaleBanner() // Single composable at the top
        }
        items(count = 10) { index ->
            CategoryHeader() // Header for the category

            LazyRow {
                items(count = 5) { // Adjust count to match the number of products
                    ProductItem()
                }
            }
        }
    }

}

@Composable
fun CategoryHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(16.dp, bottom = 22.dp)
    ) {
        Column(
            modifier = modifier.weight(1f)
        ) {
            Text(
                text = "New",
                style = TextStyle(
                    fontSize = 34.sp,
                    fontFamily = Metropolis,
                    fontWeight = FontWeight.Bold,
                )
            )
            Text("You've never seen it before!")
        }

        TextButton(
            onClick = {}
        ) {
            Text("View all")
        }

    }
}

//TODO: preview the whole design
@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    Home()
}
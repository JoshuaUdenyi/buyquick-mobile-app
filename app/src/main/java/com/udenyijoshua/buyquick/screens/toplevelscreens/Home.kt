package com.udenyijoshua.buyquick.screens.toplevelscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.buyquick.screens.components.FashionSaleBanner
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
package com.udenyijoshua.buyquick.screens.toplevelscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.udenyijoshua.buyquick.screens.components.FashionSaleBanner
import com.udenyijoshua.buyquick.screens.components.ProductItem
import com.udenyijoshua.buyquick.ui.theme.Metropolis
import com.udenyijoshua.buyquick.viewmodel.HomeViewModel

@Composable
fun Home(
    viewModel: HomeViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    val products by viewModel.productCategories.collectAsState()

    LazyColumn{
        item {
            FashionSaleBanner()
        }
        item {
            Column(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 180.dp)
            ) {
                CategoryHeader()
                if (products.isNotEmpty()) {
                    LazyRow(modifier = Modifier.padding(top = 8.dp)) {
                        items(products) { product -> // Use `items` for iterating the list
                            ProductItem(product = product)
                        }
                    }
                } else {
                    // Placeholder UI when products are empty
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator()
                        Text("Loading products...", fontWeight = FontWeight.Bold, style = TextStyle(fontSize = 16.sp))
                    }

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
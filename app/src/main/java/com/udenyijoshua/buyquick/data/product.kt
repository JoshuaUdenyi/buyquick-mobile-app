package com.udenyijoshua.buyquick.data


data class Product(
    val productName: String,
    val productBrand: String,
    val productPrice: Double,
    val isProductNew: Boolean,
    val productImageUrl: String,
    val productRating: Double,
    val ratingCount: Double,
    val productDiscount: Double,
    val productHasDiscount: Boolean,
)
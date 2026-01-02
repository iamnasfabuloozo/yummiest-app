package com.nativeappwips.yummiest

fun interface OnItemAddToCartListener {
    fun onItemAddToCart(position: Int, item: FoodItem)
}
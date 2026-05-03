package com.example.ayeshafinalappproject.Modules.Cart.Model

import com.example.ayeshafinalappproject.Modules.Home.Model.Product

data class CartItem(
    val product: Product,
    val quantity: Int,
    val selectedSize: String,
    val selectedColor: String
)

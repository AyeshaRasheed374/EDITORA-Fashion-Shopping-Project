package com.example.ayeshafinalappproject.Modules.Home.Model

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val imageRes: Int,
    val category: String,
    val isFavorite: Boolean = false,
    val description: String = ""
)

data class Collection(
    val name: String,
    val imageRes: Int
)

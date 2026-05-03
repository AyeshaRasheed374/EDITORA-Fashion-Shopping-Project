package com.example.ayeshafinalappproject.Modules.Wishlist.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.Modules.Home.Model.Product
import com.example.ayeshafinalappproject.Modules.Home.View.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistView(
    onBack: () -> Unit,
    onProductClick: (Product) -> Unit
) {
    // Sample wishlist data
    val wishlistItems = listOf(
        Product("1", "Frock", 1999.0, android.R.drawable.ic_menu_gallery, "Dresses", isFavorite = true),
        Product("2", "Floral Dress", 2299.0, android.R.drawable.ic_menu_gallery, "Dresses", isFavorite = true),
        Product("3", "White Frock", 599.0, android.R.drawable.ic_menu_gallery, "Dresses", isFavorite = true),
        Product("4", "Denim Jean", 1499.0, android.R.drawable.ic_menu_gallery, "Pants", isFavorite = true),
        Product("5", "Cocktail Dress", 1799.0, android.R.drawable.ic_menu_gallery, "Dresses", isFavorite = true),
        Product("6", "Top", 1199.0, android.R.drawable.ic_menu_gallery, "Tops", isFavorite = true)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Wishlist", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize().padding(padding).background(Color.White)
        ) {
            items(wishlistItems) { product ->
                ProductCard(product = product, onClick = onProductClick)
            }
        }
    }
}

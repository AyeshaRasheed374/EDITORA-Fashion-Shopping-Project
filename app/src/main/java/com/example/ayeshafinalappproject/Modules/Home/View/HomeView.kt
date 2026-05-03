package com.example.ayeshafinalappproject.Modules.Home.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ayeshafinalappproject.Modules.Home.Model.Product
import com.example.ayeshafinalappproject.Modules.Home.Model.Collection
import com.example.ayeshafinalappproject.Modules.Home.ViewModel.HomeViewModel
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@Composable
fun HomeView(
    onProductClick: (Product) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val featuredCollections by viewModel.featuredCollections.collectAsState()
    val discoverStyleProducts by viewModel.discoverStyleProducts.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Logo and Header
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery), // Placeholder
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = "EDITORA",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Style that defines you",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Search Bar
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            placeholder = { Text("Search \"Dresses\"") },
            trailingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF5F5F5),
                unfocusedContainerColor = Color(0xFFF5F5F5),
                disabledContainerColor = Color(0xFFF5F5F5),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Featured Collections
        Text(
            text = "Featured Collections",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(featuredCollections) { collection ->
                CollectionCard(collection)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Discover Style
        Text(
            text = "Discover Style",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Simplified Grid for demonstration inside scrollable column
        // In a real app, you might use a non-scrollable grid or flow row here
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            discoverStyleProducts.chunked(2).forEach { rowProducts ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    rowProducts.forEach { product ->
                        Box(modifier = Modifier.weight(1f)) {
                            ProductCard(product, onProductClick)
                        }
                    }
                    if (rowProducts.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = { /* View All */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryPink)
        ) {
            Text("View All")
        }
        Spacer(modifier = Modifier.height(80.dp)) // For bottom nav padding
    }
}

@Composable
fun CollectionCard(collection: Collection) {
    Box(
        modifier = Modifier
            .size(160.dp, 200.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = collection.imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2f))
        )
        Text(
            text = collection.name,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp)
        )
    }
}

@Composable
fun ProductCard(product: Product, onClick: (Product) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(product) },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Box(modifier = Modifier.height(180.dp)) {
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                // Heart icon placeholder
                Icon(
                    painter = painterResource(id = android.R.drawable.btn_star),
                    contentDescription = null,
                    tint = if (product.isFavorite) PrimaryPink else Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(24.dp)
                )
            }
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = product.name, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                Text(text = "Rs. ${product.price}", fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

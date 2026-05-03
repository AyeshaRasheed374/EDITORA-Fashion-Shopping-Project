package com.example.ayeshafinalappproject.Modules.ProductDetail.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.Modules.Home.Model.Product
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailView(
    product: Product,
    onBack: () -> Unit,
    onAddToCart: () -> Unit
) {
    var selectedColor by remember { mutableStateOf("Grey") }
    var selectedSize by remember { mutableStateOf("XS") }

    Scaffold(
        bottomBar = {
            Button(
                onClick = onAddToCart,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryPink)
            ) {
                Text("Add to Cart", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            Box(modifier = Modifier.height(400.dp)) {
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.White.copy(alpha = 0.5f), CircleShape)
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FloatingActionButton(
                        onClick = {},
                        containerColor = Color.White,
                        modifier = Modifier.size(40.dp),
                        shape = CircleShape
                    ) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = null, modifier = Modifier.size(20.dp))
                    }
                    FloatingActionButton(
                        onClick = {},
                        containerColor = Color.White,
                        modifier = Modifier.size(40.dp),
                        shape = CircleShape
                    ) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = null, modifier = Modifier.size(20.dp), tint = PrimaryPink)
                    }
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = product.name, fontSize = 18.sp, color = Color.Gray)
                Text(text = "Rs. ${product.price}", fontSize = 22.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "Color", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("Pink", "Grey", "Black").forEach { color ->
                        ColorOption(
                            name = color,
                            isSelected = selectedColor == color,
                            onClick = { selectedColor = color }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "Size", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("XS", "S", "M", "L", "XL").forEach { size ->
                        SizeOption(
                            size = size,
                            isSelected = selectedSize == size,
                            onClick = { selectedSize = size }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "Description", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Provides comfort, breath ability, and ease of care, making it excellent for everyday wear. It can have a smooth jersey texture, a plush and cozy French terry loop back interior or a waffle knit pattern.",
                    color = Color.Gray,
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ColorOption(name: String, isSelected: Boolean, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .border(
                1.dp,
                if (isSelected) PrimaryPink else Color.Transparent,
                RoundedCornerShape(8.dp)
            ),
        color = if (isSelected) PrimaryPink else Color.Transparent
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = if (isSelected) Color.White else Color.Gray
        )
    }
}

@Composable
fun SizeOption(size: String, isSelected: Boolean, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .size(45.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .border(
                1.dp,
                if (isSelected) PrimaryPink else Color.Transparent,
                RoundedCornerShape(8.dp)
            ),
        color = if (isSelected) PrimaryPink else Color.Transparent
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = size,
                color = if (isSelected) Color.White else Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

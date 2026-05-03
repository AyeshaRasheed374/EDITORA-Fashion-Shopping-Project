package com.example.ayeshafinalappproject.Modules.Cart.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
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
import com.example.ayeshafinalappproject.Modules.Cart.Model.CartItem
import com.example.ayeshafinalappproject.Modules.Cart.ViewModel.CartViewModel
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartView(
    onBack: () -> Unit,
    onCheckout: () -> Unit,
    viewModel: CartViewModel = viewModel()
) {
    val cartItems by viewModel.cartItems.collectAsState()
    val subtotal = viewModel.getSubtotal()
    val deliveryFee = 100.0
    val discount = 100.0
    val total = subtotal + deliveryFee - discount

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("My Cart", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Clear Cart */ }) {
                        Icon(Icons.Default.Delete, contentDescription = "Clear", tint = Color.LightGray)
                    }
                }
            )
        },
        bottomBar = {
            Button(
                onClick = onCheckout,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryPink)
            ) {
                Text("Proceed To Checkout", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(cartItems) { item ->
                CartItemRow(
                    item = item,
                    onIncrease = { viewModel.updateQuantity(item, 1) },
                    onDecrease = { viewModel.updateQuantity(item, -1) },
                    onRemove = { viewModel.removeItem(item) }
                )
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text("Order Summary", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                OrderSummaryCard(subtotal, deliveryFee, discount, total)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun CartItemRow(
    item: CartItem,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().border(1.dp, PrimaryPink.copy(alpha = 0.2f), RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.product.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = item.product.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "Size: ${item.selectedSize} | Color: ${item.selectedColor}", color = Color.Gray, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Rs. ${item.product.price}", fontWeight = FontWeight.Bold, color = Color.Black)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onDecrease, modifier = Modifier.size(24.dp)) {
                    Text("-", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
                Text(text = "${item.quantity}", modifier = Modifier.padding(horizontal = 8.dp), fontWeight = FontWeight.Bold)
                IconButton(onClick = onIncrease, modifier = Modifier.size(24.dp)) {
                    Icon(Icons.Default.Add, contentDescription = null, tint = PrimaryPink, modifier = Modifier.size(16.dp))
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = onRemove, modifier = Modifier.size(24.dp)) {
                    Icon(Icons.Default.Delete, contentDescription = null, tint = Color.LightGray, modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}

@Composable
fun OrderSummaryCard(subtotal: Double, delivery: Double, discount: Double, total: Double) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            SummaryRow("Subtotal", "Rs. $subtotal")
            SummaryRow("Delivery", "Rs. $delivery")
            SummaryRow("Discount", "Rs. $discount")
            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Total", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text("Rs. $total", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun SummaryRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = Color.Gray)
        Text(text = value, fontWeight = FontWeight.Medium)
    }
}

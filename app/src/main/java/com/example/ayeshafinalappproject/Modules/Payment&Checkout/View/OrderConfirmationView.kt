package com.example.ayeshafinalappproject.Modules.PaymentCheckout.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderConfirmationView(
    onBack: () -> Unit,
    onContinueShopping: () -> Unit,
    onViewOrderDetails: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Confirm Order", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CheckoutProgress(step = 2)

            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(PrimaryPink),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(60.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Order Confirmed!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(2.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    OrderInfoRow("Order ID", "#EDT2546")
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), thickness = 0.5.dp)
                    OrderInfoRow("Items", "2 Items")
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), thickness = 0.5.dp)
                    OrderInfoRow("Payment Method", "Cash On Delivery")
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), thickness = 0.5.dp)
                    OrderInfoRow("Total Amount", "Rs. 6,598")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Estimated Delivery: 3-5 Working Days",
                color = Color.Gray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onContinueShopping,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryPink)
            ) {
                Text("Continue Shopping", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            TextButton(onClick = onViewOrderDetails) {
                Text("View Order Details", color = PrimaryPink)
            }
        }
    }
}

@Composable
fun OrderInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = Color.Gray)
        Text(text = value, fontWeight = FontWeight.Bold)
    }
}

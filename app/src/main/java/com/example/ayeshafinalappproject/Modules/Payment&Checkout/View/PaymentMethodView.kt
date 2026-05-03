package com.example.ayeshafinalappproject.Modules.PaymentCheckout.View

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethodView(onBack: () -> Unit, onContinue: () -> Unit) {
    var selectedMethod by remember { mutableStateOf("Cash on Delivery") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Payment Method", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            Button(
                onClick = onContinue,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryPink)
            ) {
                Text("Continue", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp)
        ) {
            CheckoutProgress(step = 1)

            Spacer(modifier = Modifier.height(32.dp))
            Text("Select Payment Method", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(24.dp))

            PaymentOption(
                title = "Credit or Debit Card",
                iconRes = android.R.drawable.ic_menu_agenda, // Placeholder
                isSelected = selectedMethod == "Credit Card",
                onClick = { selectedMethod = "Credit Card" }
            )
            Spacer(modifier = Modifier.height(16.dp))
            PaymentOption(
                title = "Cash on Delivery",
                iconRes = android.R.drawable.ic_menu_send, // Placeholder
                isSelected = selectedMethod == "Cash on Delivery",
                onClick = { selectedMethod = "Cash on Delivery" }
            )
            Spacer(modifier = Modifier.height(16.dp))
            PaymentOption(
                title = "Digital Wallet",
                iconRes = android.R.drawable.ic_menu_agenda, // Placeholder
                isSelected = selectedMethod == "Digital Wallet",
                onClick = { selectedMethod = "Digital Wallet" }
            )
        }
    }
}

@Composable
fun PaymentOption(title: String, iconRes: Int, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .border(
                1.dp,
                if (isSelected) PrimaryPink else Color.LightGray.copy(alpha = 0.5f),
                RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF5F5F5)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(painter = painterResource(id = iconRes), contentDescription = null, modifier = Modifier.size(24.dp))
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, modifier = Modifier.weight(1f), fontSize = 16.sp, fontWeight = FontWeight.Medium)
            if (isSelected) {
                RadioButton(selected = true, onClick = null, colors = RadioButtonDefaults.colors(selectedColor = PrimaryPink))
            } else {
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.Gray)
            }
        }
    }
}

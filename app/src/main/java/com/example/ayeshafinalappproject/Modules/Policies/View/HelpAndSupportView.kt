package com.example.ayeshafinalappproject.Modules.Policies.View

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpAndSupportView(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Help & Support", fontWeight = FontWeight.Bold) },
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
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "We understand that sometimes things don't go as expected while shopping. If you face any issues with your order, don't worry — we're here to help and guide you every step of the way.\nOur goal is to make your shopping experience smooth and enjoyable. While we always try to provide the best quality products and service, there may be times when you need assistance. In such cases, our support team is ready to help you find the best solution.\nIf you receive a product that is not as expected, damaged, or incorrect, you can easily request a return or exchange. We will review your request and take the necessary steps to resolve the issue quickly.",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "Returns, Satisfaction & Experience:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPink
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "We also understand that sometimes you may change your mind. If you no longer want an item, you can check if it is eligible for return according to our policy and submit a request.\nFor any concerns related to orders, payments, delivery, or product details, you can contact our support team. We are committed to responding as quickly as possible and ensuring your issue is resolved.\nYour satisfaction is important to us. We continuously work to improve our service and make your shopping experience better, easier, and more reliable.",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            HorizontalDivider(modifier = Modifier.fillMaxWidth().height(4.dp), color = PrimaryPink)
        }
    }
}

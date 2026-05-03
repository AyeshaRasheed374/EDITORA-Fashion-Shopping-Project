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
fun ContactUsView(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Contact Us", fontWeight = FontWeight.Bold) },
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
                text = "Customer Support:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPink
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "If you need any help regarding your orders, payments, delivery status, returns, or product information, our customer support team is always ready to assist you. We aim to provide quick and helpful responses to solve your issues as soon as possible. You can contact us directly through the app’s Help Center, email support, or live chat option (if available). Our team works to ensure that your shopping experience remains smooth, safe, and hassle-free at all times.",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "Get In Touch:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPink
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "We also understand that sometimes you may change your mind. If you no longer want an item, you can check if it is eligible for return according to our policy and submit a request. For any concerns related to orders, payments, delivery, or product details, you can contact our support team. We are committed to responding as quickly as possible and ensuring your issue is resolved. Your satisfaction is important to us. We continuously work to improve our service and make your shopping experience better, easier, and more reliable.",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            HorizontalDivider(modifier = Modifier.fillMaxWidth().height(4.dp), color = PrimaryPink)
        }
    }
}

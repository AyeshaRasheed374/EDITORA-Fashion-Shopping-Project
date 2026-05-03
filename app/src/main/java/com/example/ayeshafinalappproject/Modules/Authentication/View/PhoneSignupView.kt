package com.example.ayeshafinalappproject.Modules.Authentication.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@Composable
fun PhoneSignupView(onSendOTP: () -> Unit) {
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        
        Text(
            text = buildAnnotatedString {
                append("Sign up to get ")
                withStyle(style = SpanStyle(color = PrimaryPink, fontWeight = FontWeight.Bold)) {
                    append("45%")
                }
                append("\ndiscount on your very first\norder.")
            },
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "+91 ▼", fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.width(12.dp))
            VerticalDivider(modifier = Modifier.height(24.dp).padding(horizontal = 4.dp), color = Color.LightGray)
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                placeholder = { Text("Phone Number", color = Color.LightGray) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = onSendOTP,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryPink)
        ) {
            Text("Send OTP", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.weight(1f))
        
        // Custom Numeric Keyboard Placeholder
        CustomNumericKeyboard()
    }
}

@Composable
fun CustomNumericKeyboard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryPink)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val keys = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9"),
            listOf("", "0", "⌫")
        )
        
        keys.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { key ->
                    Surface(
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                            .padding(2.dp),
                        shape = RoundedCornerShape(4.dp),
                        color = if (key.isEmpty()) Color.Transparent else Color.White
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(text = key, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

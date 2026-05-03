package com.example.ayeshafinalappproject.Modules.Authentication.View

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationCodeView(onVerify: () -> Unit, onBack: () -> Unit) {
    var code by remember { mutableStateOf(listOf("", "", "", "")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
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
            Text(
                text = "Verification Code",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "We've sent a 6-digit code to your Phone Number",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
            ) {
                code.forEachIndexed { index, char ->
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .border(1.dp, PrimaryPink, RoundedCornerShape(12.dp))
                            .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = char, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "You will receive OTP in 00:30", color = Color.Gray, fontSize = 12.sp)

            Spacer(modifier = Modifier.height(48.dp))
            
            Text(
                text = buildAnnotatedString {
                    append("Didn't you receive the OTP? ")
                    withStyle(style = SpanStyle(color = PrimaryPink, fontWeight = FontWeight.Bold)) {
                        append("Resend OTP")
                    }
                },
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = onVerify,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryPink)
            ) {
                Text("Verify", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.weight(1f))
            CustomNumericKeyboard()
        }
    }
}

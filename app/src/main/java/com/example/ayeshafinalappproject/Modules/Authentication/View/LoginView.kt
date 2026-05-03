package com.example.ayeshafinalappproject.Modules.Authentication.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@Composable
fun LoginView(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onGoogleClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Text(text = "EDITORA", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(text = "Style that defines you", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Welcome Back", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Login to explore the latest fashion trends", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Email Address",
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("example@email.com") },
            colors = TextFieldDefaults.colors(
                containerColor = Color(0xFFF5F5F5),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Password",
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                containerColor = Color(0xFFF5F5F5),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryPink),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("LOGIN", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        Row(verticalAlignment = Alignment.CenterVertically) {
            HorizontalDivider(modifier = Modifier.weight(1f))
            Text(" Or Continue With ", color = Color.Black, fontSize = 14.sp)
            HorizontalDivider(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(24.dp))

        IconButton(onClick = onGoogleClick) {
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery), // Placeholder for Google Icon
                contentDescription = "Google Sign In",
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = buildAnnotatedString {
                append("Don't have an Account? ")
                withStyle(style = SpanStyle(color = PrimaryPink, fontWeight = FontWeight.Bold)) {
                    append("Sign Up")
                }
            },
            modifier = Modifier.clickable { onSignUpClick() }
        )
    }
}

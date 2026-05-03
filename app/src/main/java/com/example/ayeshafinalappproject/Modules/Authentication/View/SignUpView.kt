package com.example.ayeshafinalappproject.Modules.Authentication.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun SignUpView(
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var agreeToTerms by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )
        Text(text = "EDITORA", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Style that defines you", fontSize = 12.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Create Account", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Join us and start your fashion journey", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(24.dp))

        InputField(label = "First Name", value = firstName, onValueChange = { firstName = it })
        Spacer(modifier = Modifier.height(12.dp))
        InputField(label = "Last Name", value = lastName, onValueChange = { lastName = it })
        Spacer(modifier = Modifier.height(12.dp))
        InputField(label = "Email Address", value = email, onValueChange = { email = it }, placeholder = "example@email.com")
        Spacer(modifier = Modifier.height(12.dp))
        InputField(label = "Password", value = password, onValueChange = { password = it }, isPassword = true)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = agreeToTerms,
                onCheckedChange = { agreeToTerms = it },
                colors = CheckboxDefaults.colors(checkedColor = PrimaryPink)
            )
            Text(
                text = buildAnnotatedString {
                    append("I agree to the ")
                    withStyle(style = SpanStyle(color = PrimaryPink)) { append("Terms") }
                    append(" & ")
                    withStyle(style = SpanStyle(color = PrimaryPink)) { append("Privacy Policy") }
                },
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onSignUpClick,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryPink),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("SIGN UP", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = buildAnnotatedString {
                append("Already have an Account? ")
                withStyle(style = SpanStyle(color = PrimaryPink, fontWeight = FontWeight.Bold)) {
                    append("Login")
                }
            },
            modifier = Modifier.clickable { onLoginClick() }
        )
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    isPassword: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(placeholder) },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            colors = TextFieldDefaults.colors(
                containerColor = Color(0xFFF5F5F5),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )
    }
}

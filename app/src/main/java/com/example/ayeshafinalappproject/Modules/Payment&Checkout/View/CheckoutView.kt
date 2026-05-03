package com.example.ayeshafinalappproject.Modules.PaymentCheckout.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutView(onBack: () -> Unit, onContinue: () -> Unit) {
    var fullName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var areaStreet by remember { mutableStateOf("") }
    var landmark by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Checkout", fontWeight = FontWeight.Bold) },
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
                .verticalScroll(rememberScrollState())
        ) {
            // Progress Bar
            CheckoutProgress(step = 0)

            Spacer(modifier = Modifier.height(24.dp))
            Text("Contact", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            CheckoutTextField(value = fullName, onValueChange = { fullName = it }, placeholder = "Full Name")
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Surface(
                    modifier = Modifier.height(56.dp).width(80.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFF5F5F5)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text("+91 ▼", fontSize = 14.sp)
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                CheckoutTextField(value = phone, onValueChange = { phone = it }, placeholder = "7886556397", modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(12.dp))
            CheckoutTextField(value = email, onValueChange = { email = it }, placeholder = "Email")

            Spacer(modifier = Modifier.height(24.dp))
            Text("Address", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            CheckoutTextField(value = areaStreet, onValueChange = { areaStreet = it }, placeholder = "Area / Street")
            Spacer(modifier = Modifier.height(12.dp))
            CheckoutTextField(value = landmark, onValueChange = { landmark = it }, placeholder = "Landmark")
            Spacer(modifier = Modifier.height(12.dp))
            CheckoutTextField(value = city, onValueChange = { city = it }, placeholder = "City")
            Spacer(modifier = Modifier.height(12.dp))
            CheckoutTextField(value = state, onValueChange = { state = it }, placeholder = "State")
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun CheckoutProgress(step: Int) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StepCircle(active = step >= 0, iconRes = android.R.drawable.ic_dialog_map)
        ProgressLine(active = step >= 1)
        StepCircle(active = step >= 1, iconRes = android.R.drawable.ic_menu_agenda)
        ProgressLine(active = step >= 2)
        StepCircle(active = step >= 2, iconRes = android.R.drawable.ic_input_add)
    }
}

@Composable
fun StepCircle(active: Boolean, iconRes: Int) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(if (active) PrimaryPink else Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        // Icon logic simplified
    }
}

@Composable
fun ProgressLine(active: Boolean) {
    Box(
        modifier = Modifier
            .width(60.dp)
            .height(2.dp)
            .background(if (active) PrimaryPink else Color.LightGray)
    )
}

@Composable
fun CheckoutTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(placeholder, color = Color.LightGray) },
        colors = TextFieldDefaults.colors(
            containerColor = Color(0xFFF5F5F5),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp)
    )
}

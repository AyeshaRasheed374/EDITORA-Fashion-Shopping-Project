package com.example.ayeshafinalappproject.Modules.Home.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileView(
    onNavigate: (String) -> Unit,
    onLogout: () -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("My Profile", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Default.Person, contentDescription = null, tint = PrimaryPink)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* Back */ }) {
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
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            ProfileInputField(label = "Full Name", value = fullName, onValueChange = { fullName = it })
            Spacer(modifier = Modifier.height(16.dp))
            ProfileInputField(label = "Email Address", value = email, onValueChange = { email = it })
            Spacer(modifier = Modifier.height(16.dp))
            ProfileInputField(label = "Phone Number", value = phone, onValueChange = { phone = it })

            Spacer(modifier = Modifier.height(32.dp))

            ProfileMenuItem(Icons.Default.FavoriteBorder, "Wishlist", onClick = { onNavigate("wishlist") })
            ProfileMenuItem(Icons.Default.ShoppingBag, "My Orders", onClick = { onNavigate("orders") })
            ProfileMenuItem(Icons.Default.LocationOn, "Manage Address", onClick = { onNavigate("address") })
            ProfileMenuItem(Icons.Default.Description, "Terms of Services", onClick = { onNavigate("terms") })
            ProfileMenuItem(Icons.Default.PrivacyTip, "Privacy Policy", onClick = { onNavigate("privacy") })
            ProfileMenuItem(Icons.Default.Help, "Help and Support", onClick = { onNavigate("help") })
            ProfileMenuItem(Icons.Default.HeadsetMic, "Contact Us", onClick = { onNavigate("contact") })

            Spacer(modifier = Modifier.height(32.dp))
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLogout() }
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Logout, contentDescription = null, tint = PrimaryPink, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Logout", color = PrimaryPink, fontWeight = FontWeight.Medium)
            }
            
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun ProfileInputField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column {
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, PrimaryPink.copy(alpha = 0.3f), RoundedCornerShape(12.dp)),
            colors = TextFieldDefaults.colors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )
    }
}

@Composable
fun ProfileMenuItem(icon: ImageVector, title: String, onClick: () -> Unit) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = PrimaryPink, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, modifier = Modifier.weight(1f), fontSize = 16.sp, color = Color.Gray)
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = PrimaryPink)
        }
        HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray.copy(alpha = 0.5f))
    }
}

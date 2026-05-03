package com.example.ayeshafinalappproject.Modules.Home.View

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

data class Address(
    val id: String,
    val name: String,
    val addressLine: String,
    val phone: String,
    val isDefault: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageAddressView(onBack: () -> Unit, onAddAddress: () -> Unit) {
    val addresses = listOf(
        Address("1", "Sarang", "House Number 65, Model Town,\nJalandhar, 144003", "+91 8423675412", true),
        Address("2", "Amit Thakur", "SCO 50-51, Sub. City Center, Sector 34A,\nChandigarh, 160022", "+91 8423675412", false)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Manage Address", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onAddAddress) {
                        Icon(Icons.Default.AddBox, contentDescription = "Add", tint = Color.Black)
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(addresses) { address ->
                AddressCard(address)
            }
        }
    }
}

@Composable
fun AddressCard(address: Address) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                1.dp,
                if (address.isDefault) PrimaryPink else Color.LightGray.copy(alpha = 0.3f),
                RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = address.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = address.addressLine, color = Color.Gray, fontSize = 14.sp)
            Text(text = address.phone, color = Color.Gray, fontSize = 14.sp)
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (address.isDefault) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(PrimaryPink, RoundedCornerShape(4.dp))
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(Color.LightGray.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (address.isDefault) "Default" else "Set as Default",
                        fontSize = 14.sp,
                        color = if (address.isDefault) Color.Black else Color.Gray
                    )
                }
                
                Row {
                    IconButton(onClick = { /* Edit */ }) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit", tint = PrimaryPink)
                    }
                    IconButton(onClick = { /* Delete */ }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = PrimaryPink)
                    }
                }
            }
        }
    }
}

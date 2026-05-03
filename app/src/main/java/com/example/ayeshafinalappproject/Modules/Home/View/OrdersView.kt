package com.example.ayeshafinalappproject.Modules.Home.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ayeshafinalappproject.ui.theme.PrimaryPink

data class OrderItem(
    val name: String,
    val date: String,
    val price: String,
    val status: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersView(onBack: () -> Unit) {
    val orders = listOf(
        OrderItem("Grey Top", "13 July, 2024", "$4,599", "Track", android.R.drawable.ic_menu_gallery),
        OrderItem("Vintage Dress", "7 July, 2024", "$1,499", "Delivered", android.R.drawable.ic_menu_gallery),
        OrderItem("Cocktail Dress", "28 June, 2024", "$1,999", "Cancelled", android.R.drawable.ic_menu_gallery)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("My Orders", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 16.dp)) {
            Text(text = "Here are your orders.", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(orders) { order ->
                    OrderCard(order)
                }
            }
        }
    }
}

@Composable
fun OrderCard(order: OrderItem) {
    val statusColor = when(order.status) {
        "Track" -> Color(0xFFD1C4E9)
        "Delivered" -> Color(0xFFB9F6CA)
        "Cancelled" -> Color(0xFFFF8A80)
        else -> Color.LightGray
    }
    
    val statusTextColor = when(order.status) {
        "Track" -> Color(0xFF673AB7)
        "Delivered" -> Color(0xFF00C853)
        "Cancelled" -> Color(0xFFD32F2F)
        else -> Color.Black
    }

    Card(
        modifier = Modifier.fillMaxWidth().border(1.dp, if(order.status == "Track") PrimaryPink.copy(alpha = 0.3f) else Color.LightGray.copy(alpha = 0.3f), RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = order.imageRes),
                contentDescription = null,
                modifier = Modifier.size(60.dp).clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = order.name, fontWeight = FontWeight.Bold)
                    Text(text = order.price, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = order.date, color = Color.Gray, fontSize = 12.sp)
                    Surface(
                        color = statusColor,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = order.status,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            fontSize = 12.sp,
                            color = statusTextColor,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

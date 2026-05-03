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
fun TermsOfServiceView(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Terms of Services", fontWeight = FontWeight.Bold) },
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
                text = "People often misunderstand how things happen and wrongly complain or blame others. But the truth is that everything has a reason, and if we look carefully, we can understand it.\nNo one likes pain or suffering for its own sake. People don't want to go through difficulties without a reason. However, they are willing to work hard and face challenges if they believe it will bring them some benefit or happiness. In the same way, people avoid discomfort unless it helps them achieve something important.",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "Orders, Pricing & Liability:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryPink
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "There is no person who loves pain just because it is pain. People only accept difficulties when they expect something good in return. That's why they work, struggle, and stay patient—to gain something valuable. Similarly, people do not choose pleasure in a way that causes harm or trouble. They try to make choices that bring them happiness without negative consequences.\nIn simple terms, people act based on what they think will bring them benefit. They work hard, avoid unnecessary pain, and make efforts to improve their lives.\nPeople do tasks, put in effort, and sometimes face discomfort because it helps them achieve results. Even though things can be difficult, working hard and taking responsibility is part of reaching success.",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            HorizontalDivider(modifier = Modifier.fillMaxWidth().height(4.dp), color = PrimaryPink)
        }
    }
}

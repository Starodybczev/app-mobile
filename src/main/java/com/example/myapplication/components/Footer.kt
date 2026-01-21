package com.example.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myapplication.styles.Gap16

@Composable
fun Footer(){
    val context = LocalContext.current
    val appName = context.applicationInfo
        .loadLabel(context.packageManager)
        .toString()

    Column(
        modifier = Modifier
            .background(Color(0xFF121212))
            .padding(20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            space = Gap16,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Design by Wiktor Dev", color = Color.White)
        Text(text = appName , style = MaterialTheme.typography.titleLarge, color = Color.White)
    }
}
package com.example.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun Header(){
    val context = LocalContext.current
    val appName = context.applicationInfo
        .loadLabel(context.packageManager)
        .toString()

    Row(
        modifier = Modifier
            .background(Color(0xFF9A67EA))
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = appName, style = MaterialTheme.typography.titleLarge, color = Color.White)
    }
}
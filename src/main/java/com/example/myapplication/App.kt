package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.components.Footer
import com.example.myapplication.components.Header
import com.example.myapplication.features.InputSum

@Composable
fun App() {
    Scaffold(
        containerColor = Color(0xFF9A67EA),
        topBar = {
            Header()
        },
        bottomBar = {
            Footer()
        }
    ) { padding ->
        InputSum(
            modifier = Modifier.padding(padding).background(Color(0xFFBB86FC)).padding(0.dp, 20.dp)
        )
    }
}

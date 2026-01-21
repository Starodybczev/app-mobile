package com.example.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import com.example.myapplication.styles.Gap16

@Composable
fun InputBlock(num1: String, num2: String, onAChange: (String) -> Unit, onBChange: (String) -> Unit){
    Column(verticalArrangement = Arrangement.spacedBy(Gap16)) {
        TextField(
            value = num1,
            onValueChange = onAChange,
            label = { Text("A") }
        )

        TextField(
            value = num2,
            onValueChange = onBChange,
            label = { Text("B") }
        )
    }
}

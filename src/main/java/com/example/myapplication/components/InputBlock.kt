package com.example.myapplication.components

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.platform.LocalConfiguration
import com.example.myapplication.styles.Gap16

@Composable
fun InputBlock(num1: String, num2: String, onAChange: (String) -> Unit, onBChange: (String) -> Unit){

    val isLandscape =
        LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

    Column(verticalArrangement = Arrangement.spacedBy(Gap16)) {
        if (isLandscape) {
            Row(horizontalArrangement = Arrangement.spacedBy(Gap16)) {
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
        }else{
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
    }
}

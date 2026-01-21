package com.example.myapplication.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.components.InputBlock
import com.example.myapplication.styles.Gap16
import com.example.myapplication.ux.Screen


@Composable
fun InputSum(modifier: Any) {
    var num_one by remember { mutableStateOf("") }
    var num_two by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<Double?>(null) }

    fun sum() {
        val x = num_one.toDoubleOrNull() ?: return
        val a = num_two.toDoubleOrNull() ?: return
        val b = num_two.toDoubleOrNull() ?: return

        result = if (x > 6) {
            (6 * x * x - a * b) / (2 * x * x)
        } else {
            4 * (x + a * a + b * b)
        }
    }

    val isEnable =
        num_one.toIntOrNull()?.let { it != 0 } == true &&
        num_two.toIntOrNull()?.let { it != 0 } == true



    Screen {
        Column(
            modifier = Modifier.imePadding(),
            verticalArrangement = Arrangement.spacedBy(
                space = Gap16,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.icon_sum),
                contentDescription = null,
                modifier = Modifier.width(50.dp),
                contentScale = ContentScale.Fit
            )
            Text("Please Enter Number", color = Color.White)
            InputBlock(
                num1 = num_one,
                num2 = num_two,
                onAChange = {num_one = it},
                onBChange = {num_two = it}
            )

            Text(text = result?.let { "Result = $it" } ?: "Result = Empty", color = Color.White)

            Button(onClick = {sum()}, enabled = isEnable) {
                Text("Summ")

            }

        }
    }
}

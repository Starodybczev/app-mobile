package com.example.myapplication.features

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.example.myapplication.components.InputBlock



@Composable
 fun InputSumContent(
    num_one: String,
    num_two: String,
    result: Double?,
    isEnable: Boolean,
    onAChange: (String) -> Unit,
    onBChange: (String) -> Unit,
    onSum: () -> Unit
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
        onAChange = onAChange,
        onBChange = onBChange
    )

    Text(
        text = result?.let { "Result = $it" } ?: "Result = Empty",
        color = Color.White
    )

    Button(onClick = onSum, enabled = isEnable) {
        Text("Summ")
    }
}

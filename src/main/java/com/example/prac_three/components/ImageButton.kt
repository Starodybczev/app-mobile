package com.example.prac_three.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageButton(
    @DrawableRes imageRes: Int,
    description: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier.size(120.dp),
        shape = RoundedCornerShape(12.dp), // лёгкое скругление
        contentPadding = PaddingValues(0.dp), // убираем внутренние отступы
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2E2E2E)
        )
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = description,
                modifier = Modifier.size(80.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}
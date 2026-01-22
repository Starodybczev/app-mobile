package com.example.myapplication.features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.styles.Gap16
import com.example.myapplication.ux.Screen


@Composable
fun InputSum(
    modifier: Modifier = Modifier
) {
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



    Screen(modifier = modifier) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            val isCompactHeight = maxHeight < 420.dp

            if (isCompactHeight) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .imePadding(),
                    verticalArrangement = Arrangement.spacedBy(Gap16),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    InputSumContent(
                        num_one,
                        num_two,
                        result,
                        isEnable,
                        onAChange = { num_one = it },
                        onBChange = { num_two = it },
                        onSum = { sum() }
                    )
                }
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(Gap16),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        InputSumContent(
                            num_one,
                            num_two,
                            result,
                            isEnable,
                            onAChange = { num_one = it },
                            onBChange = { num_two = it },
                            onSum = { sum() }
                        )
                    }
                }
            }

        }
    }
}


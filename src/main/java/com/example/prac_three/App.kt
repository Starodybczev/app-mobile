package com.example.prac_three

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prac_three.components.ImageButton


@Composable
fun App(navControler: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Text("Select Action", style = MaterialTheme.typography.titleLarge)
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageButton(
                imageRes = R.drawable.add_tasks,
                description = "Added",
                onClick = {
                    navControler.navigate("create_tasks")
                }
            )
            ImageButton(
                imageRes = R.drawable.tasks_solid,
                description =  "List",
                onClick = {
                    navControler.navigate("list_tasks")
                }
            )
        }
    }
    }



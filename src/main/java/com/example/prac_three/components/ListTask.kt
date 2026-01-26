package com.example.prac_three.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prac_three.types.FormState
import kotlinx.coroutines.delay



@Composable
fun ListTask(
    navControler: NavHostController,
    tasks: List<FormState>
) {
    val focusManager = LocalFocusManager.current
    var selectedType by remember { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }

    var search by remember { mutableStateOf("") }
    var debouncedSearch by remember { mutableStateOf("") }


    // 🔹 уникальные типы Set
    val uniqueTypes = remember(tasks) {
        tasks.map { it.types }.distinct()
    }

    LaunchedEffect(search) {
        delay(300)
        debouncedSearch = search
    }

    // 🔹 фильтрация
    val filteredTasks = remember(tasks, selectedType, debouncedSearch) {
        tasks.filter { task ->
            (selectedType == null || task.types == selectedType) &&
                    task.name.lowercase().contains(debouncedSearch.lowercase())
        }
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
        .clickable(
                indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        focusManager.clearFocus()
    }
    ) {

        // ===== DROPDOWN =====
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Button(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(selectedType ?: "All types")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {

                // All
                DropdownMenuItem(
                    text = { Text("All") },
                    onClick = {
                        selectedType = null
                        expanded = false
                    }
                )

                // types
                uniqueTypes.forEach { type ->
                    DropdownMenuItem(
                        text = { Text(type) },
                        onClick = {
                            selectedType = type
                            expanded = false
                        }
                    )
                }
            }
        }
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            label = { Text("Search") }
        )

        // ===== LIST =====
        if (filteredTasks.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,

                ){
                Text(
                    "Not found Tasks",
                    modifier = Modifier.padding(16.dp)
                )
            }
        } else {
            filteredTasks.forEach { task ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = task.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = task.desc,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.DarkGray
                        )

                        HorizontalDivider()

                        Text(
                            text = "type: ${task.types}",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color(0xFF03DAC5)
                        )
                    }
                }
            }
        }
    }
}


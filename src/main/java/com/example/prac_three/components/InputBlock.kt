package com.example.prac_three.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.prac_three.types.FormState
import com.example.prac_three.ux.Screen

@Composable
fun InputBlock(
    modifier: Modifier = Modifier,
    formState: FormState,
    onFormChange: (FormState) -> Unit,
    onSubmit: () -> Unit
    )
{
    // added list Set
    val types = listOf(
        "Lessons",
        "Lives",
        "Music",
        "Personal"
    )

    val isEneble = formState.name.isNotBlank() &&
            formState.desc.isNotBlank() &&
            formState.types.isNotBlank()





    @Composable
    fun Element(){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text("Added Task", style = MaterialTheme.typography.titleLarge)
            TextField(
                value = formState.name,
                onValueChange = {onFormChange(formState.copy(name = it))},
                label = {Text("name")}
            )
            TextField(
                value = formState.desc,
                onValueChange = { onFormChange(formState.copy(desc = it))},
                singleLine = false,
                modifier = Modifier
                    .height(100.dp)
                    .width(280.dp),
                maxLines = Int.MAX_VALUE,
                label = {Text("description")}
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TaskTypeSelect(
                    types = types,
                    selectedType = formState.types,
                    onTypeSelected = {
                        onFormChange(formState.copy(types = it))
                    }
                )

                Button(
                    enabled = isEneble,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF03DAC5),
                        contentColor = Color.Black
                    ),
                    onClick = onSubmit
                ) {
                    Text("Added Task")
                }
            }


        }

    }


    Screen(modifier = modifier) {
        Element()
    }
}
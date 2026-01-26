package com.example.prac_three.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.prac_three.types.FormState

@Composable
fun CreateTasks(
    navControler: NavHostController,
    formState: FormState,
    onFormChange: (FormState) -> Unit,
    onSubmit: () -> Unit
)
{
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("This Page Create_Task")
        InputBlock(
            formState = formState,
            onFormChange = onFormChange,
            onSubmit = onSubmit
        )

    }
}
package com.example.prac_three

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prac_three.components.CreateTasks
import com.example.prac_three.components.ListTask
import com.example.prac_three.components.main.Footer
import com.example.prac_three.components.main.Header
import com.example.prac_three.types.FormState

@Composable
fun AppRouter(){
    val navControler = rememberNavController()
    var formState by remember { mutableStateOf(FormState()) }
    var tasks by remember { mutableStateOf(listOf<FormState>()) }



    fun addTask(task: FormState) {
        tasks = tasks + task
    }

    fun resetForm() {
        formState = FormState()
    }

    Scaffold(
        topBar = { Header(navControler) },
        bottomBar = { Footer() }
    ) { paddingValues ->
        NavHost(navControler, startDestination = "main", modifier = Modifier.padding(paddingValues)) {
            composable("main") {
                App(navControler)
            }
            composable("create_tasks") {
                CreateTasks(
                    navControler,
                    formState = formState,
                    onFormChange = { formState = it },
                    onSubmit = {
                        addTask(formState)
                        resetForm()
                    }
                )
            }
            composable("list_tasks"){
                ListTask(navControler, tasks)
            }
        }
    }
}
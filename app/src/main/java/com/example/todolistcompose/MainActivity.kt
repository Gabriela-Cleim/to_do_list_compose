package com.example.todolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolistcompose.ui.theme.ToDoListComposeTheme
import com.example.todolistcompose.view.SaveTask
import com.example.todolistcompose.view.TaskList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoListComposeTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "taskList") {
                    composable(
                        route = "taskList"
                    ){
                        TaskList(navController)
                    }
                    composable(
                        route = "saveTask"
                    ){
                        SaveTask(navController)
                    }
                }

            }
        }
    }
}

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

                // Crio uma variavel para receber a navController
                val navController = rememberNavController()

                // Aqui estou criando o objeto da navcontroller
                NavHost(navController = navController, startDestination = "taskList") {
                    composable(
                        // Defino o id que vai identificar a tela
                        route = "taskList"
                    ){
                        // Chamo a minha tela e passo o navController
                        TaskList(navController)
                    }
                    composable(
                        // Defino o id que vai identificar a tela
                        route = "saveTask"
                    ){
                        // Chamo a minha tela e passo o navController
                        SaveTask(navController)
                    }
                }

            }
        }
    }
}

package com.example.todolistcompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolistcompose.R
import com.example.todolistcompose.listItem.TaskItem
import com.example.todolistcompose.model.Task
import com.example.todolistcompose.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskList(navController: NavController){

    // Aqui define a tela como um ttodo
    Scaffold (

        modifier = Modifier.padding(top = 50.dp),
        // Cria um botão flutuante
        floatingActionButton = {
            FloatingActionButton(
                // Define a ação de clique
                onClick = {
                    // Chama o navController passado na função para passar o id da tela que vai ser aberta
                    navController.navigate("saveTask")
                }
            ) {
                // Define o icone do botão
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = null,
                    tint = White
                )
            }
        }
    ){
        val taskList: MutableList<Task> = mutableListOf(
            Task(
                task = "Jogar video game0",
                description = "testestestestestestestestestestestestest",
                priority = 0
            ),
            Task(
                task = "Jogar video game1",
                description = "testestestestestestestestestestestestest",
                priority = 1
            ),
            Task(
                task = "Jogar video game2",
                description = "testestestestestestestestestestestestest",
                priority = 2
            ),
            Task(
                task = "Jogar video game3",
                description = "testestestestestestestestestestestestest",
                priority = 3
            )
        )

        LazyColumn {
            itemsIndexed(taskList){ position, _, ->
                TaskItem(position, taskList)
            }
        }
    }


}
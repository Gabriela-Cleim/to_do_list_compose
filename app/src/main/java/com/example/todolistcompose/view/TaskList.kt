package com.example.todolistcompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.example.todolistcompose.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskList(navController: NavController){

    // Aqui define a tela como um ttodo
    Scaffold (
        // Define a cor de fundo da tela
        containerColor = Color.White,
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
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_add), contentDescription = null )
            }
        }
    ){

    }


}
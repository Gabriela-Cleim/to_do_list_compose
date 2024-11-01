package com.example.todolistcompose.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolistcompose.R
import com.example.todolistcompose.ui.theme.RED
import com.example.todolistcompose.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopBar(navController: NavController){

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = White,
                modifier = Modifier.padding(top = 26.dp),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            // Chama o navController passado na função para passar o id da tela que vai ser aberta
                            navController.navigate("TaskList")
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_back_24),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text("Save Task")
                }

            )
        }
    ) {  }
}
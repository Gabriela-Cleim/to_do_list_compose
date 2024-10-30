package com.example.todolistcompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonColors
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolistcompose.R
import com.example.todolistcompose.components.Button
import com.example.todolistcompose.components.TextBox
import com.example.todolistcompose.components.TopBar
import com.example.todolistcompose.ui.theme.RADIO_BUTTON_GREEN_DISABLE
import com.example.todolistcompose.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.example.todolistcompose.ui.theme.RADIO_BUTTON_RED_DISABLE
import com.example.todolistcompose.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.example.todolistcompose.ui.theme.RADIO_BUTTON_YELLOW_DISABLE
import com.example.todolistcompose.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.example.todolistcompose.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SaveTask(navController: NavController){

    Scaffold (
        containerColor = White,
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
                    Text("Create Task")
                }

            )
        }


    ) {
        var taskTitle by remember {
            mutableStateOf("")
        }

        var taskDescription by remember {
            mutableStateOf("")
        }

        var noTaskPriority by remember {
            mutableStateOf(false)
        }

        var lowTaskPriority by remember {
            mutableStateOf(false)
        }

        var mediumTaskPriority by remember {
            mutableStateOf(false)
        }

        var highTaskPriority by remember {
            mutableStateOf(false)
        }


        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())
        ) {
            TextBox(
                value = taskTitle,
                onValueChange = {
                    taskTitle = it
                },
                modifier = Modifier.fillMaxWidth().padding(20.dp, 100.dp, 20.dp, 0.dp),
                label = "Task Title",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            TextBox(
                value = taskDescription,
                onValueChange = {
                    taskDescription = it
                },
                modifier = Modifier.fillMaxWidth().height(150.dp).padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Description",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
            ){
                Text(text = "Nível de prioridade: ")

                RadioButton(
                    selected = lowTaskPriority,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RADIO_BUTTON_GREEN_SELECTED,
                        unselectedColor = RADIO_BUTTON_GREEN_DISABLE
                    ),
                    onClick = {
                        lowTaskPriority = !lowTaskPriority
                    }
                )

                RadioButton(
                    selected = mediumTaskPriority,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RADIO_BUTTON_YELLOW_SELECTED,
                        unselectedColor = RADIO_BUTTON_YELLOW_DISABLE
                    ),
                    onClick = {
                        mediumTaskPriority = !mediumTaskPriority
                    }
                )

                RadioButton(
                    selected = highTaskPriority,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RADIO_BUTTON_RED_SELECTED,
                        unselectedColor = RADIO_BUTTON_RED_DISABLE
                    ),
                    onClick = {
                        highTaskPriority = !highTaskPriority
                    }
                )

            }

            Button(onClick = {

            }, modifier = Modifier.fillMaxWidth().height(80.dp).padding(20.dp),
                text = "Save")
        }
    }
}

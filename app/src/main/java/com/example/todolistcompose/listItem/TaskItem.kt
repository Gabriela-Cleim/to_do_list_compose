package com.example.todolistcompose.listItem

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.todolistcompose.R
import com.example.todolistcompose.model.Task
import com.example.todolistcompose.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.example.todolistcompose.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.example.todolistcompose.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.example.todolistcompose.ui.theme.RED
import com.example.todolistcompose.ui.theme.ShapeCardPriority

@Composable
fun TaskItem(
    position: Int,
    taskList: MutableList<Task>
){

    val taskTitle = taskList[position].task
    val taskDescription = taskList[position].description
    val taskPriority = taskList[position].priority

    val priorityLevel: String =
        when(taskPriority){
            0 -> {
                "Sem prioridade"
            }
            1 -> {
                "Prioridade baixa"
            }
            2 -> {
                "Prioridade média"
            }
            else -> {
                "Prioridade alta"
            }
        }

    val color =
        when(taskPriority){
            0 -> {
                Color.White
            }
            1 -> {
                RADIO_BUTTON_GREEN_SELECTED
            }
            2 -> {
                RADIO_BUTTON_YELLOW_SELECTED
            }
            else ->{
                RADIO_BUTTON_RED_SELECTED
            }

        }

    Card(
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtTitle, txtDescription, txtPriority, cardPriority, btDelete) = createRefs()

            Text(
                text = taskTitle.toString(),
                modifier = Modifier.constrainAs(txtTitle){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = taskDescription.toString(),
                modifier = Modifier.constrainAs(txtDescription){
                    top.linkTo(txtTitle.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = priorityLevel,
                modifier = Modifier.constrainAs(txtPriority){
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            Card(
                backgroundColor = color,
                modifier = Modifier.size(20.dp).constrainAs(cardPriority){
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(txtPriority.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                },
                shape = ShapeCardPriority.large
            ) {

            }

            IconButton(
                onClick = {

                }, modifier = Modifier.constrainAs(btDelete){
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(cardPriority.end, margin = 170.dp)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_delete_24),
                    contentDescription = null,
                    tint = RED
                )

            }

        }
    }

}
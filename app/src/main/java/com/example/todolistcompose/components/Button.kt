package com.example.todolistcompose.components

import android.widget.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.todolistcompose.ui.theme.Purple80
import com.example.todolistcompose.ui.theme.White
import org.w3c.dom.Text

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
){
    Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple80,
            contentColor = White
        ),
    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 15.sp)
    }
}
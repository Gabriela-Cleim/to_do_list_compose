package com.example.todolistcompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolistcompose.ui.theme.Black
import com.example.todolistcompose.ui.theme.Purple80
import com.example.todolistcompose.ui.theme.ShapeEditText
import com.example.todolistcompose.ui.theme.White

@Composable
fun TextBox(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
){

    // Utilizando esse componente de caixa de texto pois ele é mais personalizavel
    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Black,
            focusedBorderColor = Purple80,
            focusedLabelColor = Purple80,
            backgroundColor = White,
            cursorColor = Purple80
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}









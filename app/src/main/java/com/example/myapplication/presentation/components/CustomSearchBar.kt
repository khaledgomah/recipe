package com.example.myapplication.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.screens.borderColor

@Preview
@Composable
fun CustomSearchBar(modifier: Modifier = Modifier) {

    var text by rememberSaveable {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        placeholder = {
            Text("Search")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        trailingIcon = {
            if (text.isNotEmpty()) {
                IconButton(
                    onClick = {
                        text = ""
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,

            focusedBorderColor = borderColor,
            unfocusedBorderColor = borderColor,

            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,

            focusedPlaceholderColor = Color.Gray,
            unfocusedPlaceholderColor = Color.Gray,

            focusedLeadingIconColor = Color.Gray,
            unfocusedLeadingIconColor = Color.Gray,

            focusedTrailingIconColor = Color.Gray,
            unfocusedTrailingIconColor = Color.Gray,

            cursorColor = Color.Black
        )
    )
}

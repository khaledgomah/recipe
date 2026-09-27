package com.example.myapplication.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.screens.secondary

@Composable
fun CustomChip(category: String, isSelected: Boolean, onClick:  () -> Unit)
{
    FilterChip(label = { Text(category) },
        selected = isSelected,
        onClick = onClick,
        shape = RoundedCornerShape(40.dp),
        colors = FilterChipDefaults.filterChipColors().copy(
            containerColor= Color(0xffF1F5F5),
            labelColor = Color.Black,
            selectedContainerColor = Color(secondary),
            selectedLabelColor = Color.White,
        ),
        border = null
    )
}


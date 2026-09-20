package com.example.myapplication.components

import com.example.myapplication.data.Category
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.screens.secondary

@Composable
fun CustomChip(category: Category, selectedCategoryID: Int, onClick:  (Int) -> Unit)
{
    FilterChip(label = { Text(category.name) },
        selected = selectedCategoryID == category.id,
        onClick = { onClick(category.id) },
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


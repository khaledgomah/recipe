package com.example.myapplication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import categories

@Composable
fun CategorySection(modifier: Modifier = Modifier)
{
    var selectedCategory:Int by rememberSaveable { mutableIntStateOf(categories.first().id) }
    Column(modifier) {

        SectionHeader(onSeeAll = {}, text = "Category")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding =PaddingValues(horizontal = 16.dp)
        ) {
            items(categories) {category ->
                CustomChip(selectedCategoryID = selectedCategory, onClick = {
                    selectedCategory = it
                }, category = category)
            }
        }
    }
}

package com.example.myapplication.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategorySection(modifier: Modifier = Modifier,categories: List<String>)
{
    var selectedCategory:Int by rememberSaveable { mutableIntStateOf(0) }
    Column(modifier) {
        SectionHeader(onSeeAll = {}, text = "Category")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding =PaddingValues(horizontal = 16.dp)
        ) {
            itemsIndexed(categories) {index,category ->
                CustomChip(isSelected = selectedCategory == index, onClick = {
                    selectedCategory = index
                }, category = category)
            }
        }
    }
}


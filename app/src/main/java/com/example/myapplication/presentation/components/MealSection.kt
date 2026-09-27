package com.example.myapplication.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.remote.dto.Meal
import com.example.myapplication.presentation.intent.SearchIntent
import com.example.myapplication.presentation.viewmodels.SearchViewModel

@Composable
fun MealSection(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel,
)
{
    val meals: List<Meal> = listOf(
        Meal.BREAKFAST,
        Meal.LUNCH,
        Meal.DINNER,
        Meal.SNACK
    )
    Column(modifier) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding =PaddingValues(horizontal = 16.dp)
        ) {
            items(meals) {meal ->
                CustomChip(isSelected = viewModel.uiState.collectAsState().value.meal == meal,
                    onClick = {
                    viewModel.onIntent(SearchIntent.ChangeMeal(meal))
                }, category = meal.toString())
            }
        }
    }

}

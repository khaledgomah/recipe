package com.example.myapplication.presentation.view_states

import com.example.myapplication.core.AppError
import com.example.myapplication.data.remote.dto.Meal
import com.example.myapplication.data.remote.dto.RecipeDto

data class SearchViewState(
    val meal: Meal = Meal.BREAKFAST,
    val isLoading: Boolean = true,
    val recipes: List<RecipeDto> = emptyList(),
    val error: AppError? = null,
)
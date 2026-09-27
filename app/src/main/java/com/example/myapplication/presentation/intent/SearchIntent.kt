package com.example.myapplication.presentation.intent

import com.example.myapplication.data.remote.dto.Meal


sealed class SearchIntent {
    data object GetAllRecipes: SearchIntent()
    data class ChangeMeal(
        val meal: Meal
    ) : SearchIntent()
}
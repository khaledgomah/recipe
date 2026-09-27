package com.example.myapplication.presentation.intent

sealed class HomeIntent {
    data object GetAllRecipes: HomeIntent()
    data object GetAllCategories: HomeIntent()
}
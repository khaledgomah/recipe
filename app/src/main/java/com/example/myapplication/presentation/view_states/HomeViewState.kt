package com.example.myapplication.presentation.view_states

import com.example.myapplication.data.remote.dto.RecipeDto

data class HomeViewState(
    val isLoading: Boolean = true,
    val recipes: List<RecipeDto> = emptyList(),
    val tags: List<String> = emptyList(),
    val error: String? = null
)
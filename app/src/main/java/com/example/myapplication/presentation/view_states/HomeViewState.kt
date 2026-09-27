package com.example.myapplication.presentation.view_states

import com.example.myapplication.core.AppError
import com.example.myapplication.data.remote.dto.RecipeDto

data class HomeViewState(
    val isLoadingTags: Boolean = true,
    val isLoadingRecipes: Boolean = true,

    val recipes: List<RecipeDto> = emptyList(),
    val tags: List<String> = emptyList(),

    val recipesError: AppError? = null,
    val tagsError: AppError? = null
)
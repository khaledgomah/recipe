package com.example.myapplication.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipesResponseDto(
    val recipes: List<RecipeDto>? = emptyList(),
    val total: Int,
    val skip: Int,
    val limit: Int
)

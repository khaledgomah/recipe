package com.example.myapplication.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    val id: Int,
    val name: String,
    val ingredients: List<String> = emptyList(),
    val instructions: List<String> = emptyList(),
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val servings: Int,
    val difficulty: String,
    val cuisine: String,
    val caloriesPerServing: Int,
    val tags: List<String> = emptyList(),
    val userId: Int,
    val image: String? = null,
    val rating: Double,
    val reviewCount: Int,
    val mealType: List<String> = emptyList()
)
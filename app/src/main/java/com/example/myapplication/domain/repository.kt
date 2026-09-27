package com.example.myapplication.domain

import com.example.myapplication.data.remote.dto.RecipeDto
import com.example.myapplication.data.remote.dto.RecipesResponseDto
import com.example.myapplication.core.ApiResult
import com.example.myapplication.data.remote.dto.Meal


interface Repository {

    suspend fun getAllRecipes(
        limit: Int?,
        skip: Int?
    ): ApiResult<RecipesResponseDto>
    suspend fun getAllTags(): ApiResult<List<String>>

    suspend fun getSingleRecipe(id: Int): ApiResult<RecipeDto>

    suspend fun searchRecipes(
        query: String,
        limit: Int,
        skip: Int
    ): ApiResult<RecipesResponseDto>

    suspend fun getRecipesByTag(
        tag: String
    ): ApiResult<RecipesResponseDto>

    suspend fun addRecipe(
        recipe: RecipeDto
    ): ApiResult<RecipeDto>

    suspend fun deleteRecipe(
        id: Int
    ):ApiResult<Unit>

    suspend fun updateRecipe(
        id: Int,
        recipe: RecipeDto
    ): ApiResult<RecipeDto>
    suspend fun getRecipesByMeal(
        meal: Meal
    ): ApiResult<RecipesResponseDto>

}
package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.dto.RecipeDto
import com.example.myapplication.data.remote.dto.RecipesResponseDto

interface RecipeApi {

    suspend fun getAllRecipes(
        limit:Int?= null,
        skip: Int?= null
    ): RecipesResponseDto

    suspend fun getSingleRecipe(id:Int): RecipeDto

    suspend fun searchRecipes(
        query: String,
        limit: Int,
        skip: Int
    ): RecipesResponseDto

    suspend fun getRecipesByTag(tag: String): RecipesResponseDto

    suspend fun addRecipe(recipe: RecipeDto): RecipeDto

    suspend fun deleteRecipe(id: Int)

    suspend fun updateRecipe(
        id: Int,
        recipe: RecipeDto
    ): RecipeDto

    suspend fun getAllTags(
    ): List<String>
}
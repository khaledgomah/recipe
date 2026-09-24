package com.example.myapplication.data.repository


import com.example.myapplication.data.remote.RecipeApi
import com.example.myapplication.data.remote.dto.RecipeDto
import com.example.myapplication.data.remote.dto.RecipesResponseDto
import com.example.myapplication.domain.Repository

class RepositoryImplementation(
    private val recipeApi: RecipeApi
) : Repository {

    override suspend fun getAllRecipes(
        limit: Int,
        skip: Int
    ): RecipesResponseDto {
        return recipeApi.getAllRecipes(limit, skip)
    }

    override suspend fun getSingleRecipe(id: Int): RecipeDto {
        return recipeApi.getSingleRecipe(id)
    }

    override suspend fun searchRecipes(
        query: String,
        limit: Int,
        skip: Int
    ): RecipesResponseDto {
        return recipeApi.searchRecipes(
            query = query,
            limit = limit,
            skip = skip
        )
    }

    override suspend fun getRecipesByTag(tag: String): RecipesResponseDto {
        return recipeApi.getRecipesByTag(tag)
    }

    override suspend fun addRecipe(recipe: RecipeDto): RecipeDto {
        return recipeApi.addRecipe(recipe)
    }

    override suspend fun deleteRecipe(id: Int) {
        recipeApi.deleteRecipe(id)
    }

    override suspend fun updateRecipe(
        id: Int,
        recipe: RecipeDto
    ): RecipeDto {
        return recipeApi.updateRecipe(
            id = id,
            recipe = recipe
        )
    }
}




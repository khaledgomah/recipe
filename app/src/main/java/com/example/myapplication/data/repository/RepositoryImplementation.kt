package com.example.myapplication.data.repository

import com.example.myapplication.core.ApiCall.safeApiCall
import com.example.myapplication.core.ApiResult
import com.example.myapplication.data.remote.RecipeApi
import com.example.myapplication.data.remote.dto.Meal
import com.example.myapplication.data.remote.dto.RecipeDto
import com.example.myapplication.data.remote.dto.RecipesResponseDto
import com.example.myapplication.domain.Repository

class RepositoryImplementation(
    private val recipeApi: RecipeApi
) : Repository {

    override suspend fun getAllRecipes(
        limit: Int?,
        skip: Int?
    ): ApiResult<RecipesResponseDto> {

        return safeApiCall {
            recipeApi.getAllRecipes(
                limit = limit,
                skip = skip
            )
        }
    }

    override suspend fun getAllTags(): ApiResult<List<String>> {

        return safeApiCall {
            recipeApi.getAllTags()
        }
    }

    override suspend fun getSingleRecipe(
        id: Int
    ): ApiResult<RecipeDto> {

        return safeApiCall {
            recipeApi.getSingleRecipe(id)
        }
    }

    override suspend fun searchRecipes(
        query: String,
        limit: Int,
        skip: Int
    ): ApiResult<RecipesResponseDto> {

        return safeApiCall {
            recipeApi.searchRecipes(
                query = query,
                limit = limit,
                skip = skip
            )
        }
    }

    override suspend fun getRecipesByTag(
        tag: String
    ): ApiResult<RecipesResponseDto> {

        return safeApiCall {
            recipeApi.getRecipesByTag(tag)
        }
    }

    override suspend fun addRecipe(
        recipe: RecipeDto
    ): ApiResult<RecipeDto> {

        return safeApiCall {
            recipeApi.addRecipe(recipe)
        }
    }

    override suspend fun deleteRecipe(
        id: Int
    ): ApiResult<Unit> {

        return safeApiCall {
            recipeApi.deleteRecipe(id)
        }
    }

    override suspend fun updateRecipe(
        id: Int,
        recipe: RecipeDto
    ): ApiResult<RecipeDto> {

        return safeApiCall {
            recipeApi.updateRecipe(
                id = id,
                recipe = recipe
            )
        }
    }

    override suspend fun getRecipesByMeal(meal: Meal): ApiResult<RecipesResponseDto> {
        return safeApiCall {
            recipeApi.getRecipesByMeal(
                meal = meal
            )
        }
    }
}
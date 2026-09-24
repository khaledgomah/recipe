package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.dto.RecipeDto
import com.example.myapplication.data.remote.dto.RecipesResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType


class RecipeApiImplementation(
    private val client: HttpClient
): RecipeApi {
    override suspend fun getAllRecipes(
        limit: Int,
        skip: Int
    ): RecipesResponseDto {

        return client.get(EndPoints.GET_ALL_RECIPES) {
            url {
                parameters.append("limit", limit.toString())
                parameters.append("skip", skip.toString())
            }
        }.body()
    }

    override suspend fun getSingleRecipe(id: Int): RecipeDto {
        return client.get("${EndPoints.GET_SINGLE_RECIPE}/$id") {

        }.body()
    }

    override suspend fun searchRecipes(
        query: String,
        limit: Int,

        skip: Int): RecipesResponseDto {

        return client.get(EndPoints.SEARCH_RECIPES) {
            url {
                parameters.append("limit", limit.toString())
                parameters.append("skip", skip.toString())
                parameters.append("q", query)
            }
        }.body()
    }

    override suspend fun getRecipesByTag(tag: String): RecipesResponseDto {
        return client.get("${EndPoints.GET_BY_TAG}/$tag") {
        }.body()
    }

    override suspend fun addRecipe(recipe: RecipeDto): RecipeDto {
        return client.post(EndPoints.ADD_RECIPE) {
            contentType(ContentType.Application.Json)
            setBody(recipe)
        }.body()
    }

    override suspend fun deleteRecipe(id: Int) {
        return client.delete("${EndPoints.DELETE_RECIPE}/$id").body()
    }

    override suspend fun updateRecipe(
        id: Int,
        recipe: RecipeDto
    ): RecipeDto {

            return client.put("${EndPoints.UPDATE_RECIPE}/$id") {
                contentType(ContentType.Application.Json)
                setBody(recipe)
            }.body()

    }
}
package com.example.myapplication.data.remote

object EndPoints {

    const val BASE_URL = "https://dummyjson.com"

    const val GET_ALL_RECIPES = "$BASE_URL/recipes"
    const val GET_SINGLE_RECIPE = "$BASE_URL/recipes"
    const val SEARCH_RECIPES = "$BASE_URL/recipes/search"
    const val GET_ALL_TAGS = "$BASE_URL/recipes/tags"
    const val GET_BY_TAG = "$BASE_URL/recipes/tag"
    const val ADD_RECIPE = "$BASE_URL/recipes/add"
    const val DELETE_RECIPE = "$BASE_URL/recipes"
    const val UPDATE_RECIPE = "$BASE_URL/recipes"
    const val GET_RECIPES_BY_MEAL = "$BASE_URL/recipes/meal-type"
}
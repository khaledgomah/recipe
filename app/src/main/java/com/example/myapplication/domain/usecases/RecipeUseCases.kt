package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.usecase.*

data class RecipeUseCases(
    val getAllRecipes: GetAllRecipesUseCase,
    val getSingleRecipe: GetSingleRecipeUseCase,
    val searchRecipes: SearchRecipesUseCase,
    val getRecipesByTag: GetRecipesByTagUseCase,
    val addRecipe: AddRecipeUseCase,
    val deleteRecipe: DeleteRecipeUseCase,
    val updateRecipe: UpdateRecipeUseCase
)
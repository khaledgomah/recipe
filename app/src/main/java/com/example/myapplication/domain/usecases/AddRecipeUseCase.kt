package com.example.myapplication.domain.usecase

import com.example.myapplication.data.remote.dto.RecipeDto
import com.example.myapplication.domain.Repository

class AddRecipeUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(
        recipe: RecipeDto
    ) = repository.addRecipe(recipe)
}
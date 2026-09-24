package com.example.myapplication.domain.usecase

import com.example.myapplication.data.remote.dto.RecipeDto
import com.example.myapplication.domain.Repository

class UpdateRecipeUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(
        id: Int,
        recipe: RecipeDto
    ) = repository.updateRecipe(
        id = id,
        recipe = recipe
    )
}
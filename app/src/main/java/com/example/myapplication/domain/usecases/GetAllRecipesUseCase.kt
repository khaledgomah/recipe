package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.Repository

class GetAllRecipesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(
        limit: Int,
        skip: Int
    ) = repository.getAllRecipes(
        limit = limit,
        skip = skip
    )
}
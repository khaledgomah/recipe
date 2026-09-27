package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.Repository

class GetAllRecipesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(
        limit: Int? = 10,
        skip: Int? =0
    ) = repository.getAllRecipes(
        limit = limit,
        skip = skip
    )
}
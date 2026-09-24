package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.Repository

class SearchRecipesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(
        query: String,
        limit: Int,
        skip: Int
    ) = repository.searchRecipes(
        query = query,
        limit = limit,
        skip = skip
    )
}
package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.Repository

class GetSingleRecipeUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int) =
        repository.getSingleRecipe(id)
}
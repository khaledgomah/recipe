package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.Repository

class DeleteRecipeUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Int) {
        repository.deleteRecipe(id)
    }
}
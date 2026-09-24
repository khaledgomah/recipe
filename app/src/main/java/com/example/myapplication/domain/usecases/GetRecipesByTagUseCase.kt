package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.Repository

class GetRecipesByTagUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(tag: String) =
        repository.getRecipesByTag(tag)
}
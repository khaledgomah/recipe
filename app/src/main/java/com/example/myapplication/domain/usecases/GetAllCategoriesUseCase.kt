package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.Repository

class GetAllTagsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(

    ) = repository.getAllTags()
}
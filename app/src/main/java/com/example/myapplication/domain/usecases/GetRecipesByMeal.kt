package com.example.myapplication.domain.usecases

import com.example.myapplication.data.remote.dto.Meal
import com.example.myapplication.domain.Repository

class GetRecipesByMealUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(
    meal: Meal
    ) = repository.getRecipesByMeal(
        meal = meal
    )
}
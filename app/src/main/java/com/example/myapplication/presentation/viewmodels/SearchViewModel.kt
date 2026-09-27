package com.example.myapplication.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.ApiResult
import com.example.myapplication.domain.usecases.GetRecipesByMealUseCase
import com.example.myapplication.presentation.intent.SearchIntent
import com.example.myapplication.presentation.view_states.SearchViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class SearchViewModel(
    private val useCase: GetRecipesByMealUseCase
): ViewModel(
) {
    private val _uiState = MutableStateFlow(
        SearchViewState(
            isLoading = true,
        )
    )
    val uiState: StateFlow<SearchViewState> = _uiState

    fun onIntent(intent: SearchIntent) {
        when (intent) {
            SearchIntent.GetAllRecipes -> viewModelScope.launch{
                getAllRecipes()
            }

            is SearchIntent.ChangeMeal -> viewModelScope.launch{
                _uiState.emit(_uiState.value.copy(meal = intent.meal))
                getAllRecipes()
            }
        }
        }
    private suspend fun getAllRecipes()
    {
        _uiState.emit(
            _uiState.value.copy(isLoading = true)
        )
        Log.d("viewmodel logs","start get all recipes")
        when(val response =  useCase(meal = _uiState.value.meal)) {
            is ApiResult.Error -> {
                _uiState.emit(
                    _uiState.value.copy(isLoading = false, error = response.error)
                )
                Log.e("viewmodel logs", response.error.toString())
            }
            is ApiResult.Success -> {
                _uiState.emit(
                    _uiState.value.copy(
                        isLoading = false,
                        recipes =  response.data.recipes?: emptyList(),
                        error = null
                    )
                )
                Log.d("viewmodel logs", response.data.recipes.toString())

            }
        }

    }
}


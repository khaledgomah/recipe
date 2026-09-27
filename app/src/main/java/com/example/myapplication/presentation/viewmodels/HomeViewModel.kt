package com.example.myapplication.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.ApiResult
import com.example.myapplication.domain.usecases.RecipeUseCases
import com.example.myapplication.presentation.intent.HomeIntent
import com.example.myapplication.presentation.view_states.HomeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: RecipeUseCases): ViewModel() {
    private val _uiState = MutableStateFlow(HomeViewState(
        isLoadingTags = true,
        isLoadingRecipes = true))
    val uiState: StateFlow<HomeViewState> = _uiState

    fun onIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.GetAllCategories -> {
                viewModelScope.launch {
                    getAllCategories()
                }
            }

            HomeIntent.GetAllRecipes -> {
                viewModelScope.launch {
                    getAllRecipes()
                }
            }
        }
    }
     private suspend fun getAllRecipes() {
         _uiState.emit(
             _uiState.value.copy(isLoadingRecipes = true)
         )
         Log.d("testo","start all recipes")
         when(val response = useCase.getAllRecipes()) {
             is ApiResult.Error -> {
                 _uiState.emit(
                     _uiState.value.copy(isLoadingRecipes = false, recipesError = response.error)
                 )
                 Log.d("testo", response.error.toString())
             }
             is ApiResult.Success -> {
                 _uiState.emit(
                     _uiState.value.copy(
                         isLoadingRecipes = false,
                         recipes =  response.data.recipes?: emptyList(),
                         recipesError = null
                     )
                 )
                 Log.d("testo", response.data.recipes.toString())

             }
         }
    }
    private suspend fun getAllCategories() {

        _uiState.emit(
            _uiState.value.copy(isLoadingTags = true)
        )
        when (val response = useCase.getAllTags())
        {

            is ApiResult.Error ->
            {
                _uiState.emit(
                    _uiState.value.copy(isLoadingTags = false, tagsError = response.error)
                )
                Log.d("testo", response.error.toString())
            }
            is ApiResult.Success ->
            {
                _uiState.emit(
                    _uiState.value.copy(isLoadingTags = false,
                        tags =  response.data,
                        tagsError = null)
                )
                Log.d("testo", response.data.toString())
            }
        }
    }
}



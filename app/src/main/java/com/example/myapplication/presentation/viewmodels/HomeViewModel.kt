package com.example.myapplication.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.remote.dto.RecipeDto
import com.example.myapplication.domain.usecases.RecipeUseCases
import com.example.myapplication.presentation.intent.HomeIntent
import com.example.myapplication.presentation.view_states.HomeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: RecipeUseCases): ViewModel() {
    private val _uiState = MutableStateFlow(HomeViewState())
    val uiState: StateFlow<HomeViewState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.emit(HomeViewState())
        }
    }
    fun onIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.GetAllCategories -> {
                viewModelScope.launch {
                    val result =getAllCategories().also{
                        Log.d("api results",it.toString())
                    }
                }
            }

            HomeIntent.GetAllRecipes -> {
                viewModelScope.launch {
                    val result = getAllRecipes()
                    Log.d("api results",result.toString())

                }
            }
        }
    }
     private suspend fun getAllRecipes() {
         Log.d("testo","start all recipes")
       val result = useCase.getAllRecipes()
         _uiState.emit(
             HomeViewState(isLoading = false, recipes =  result.recipes?: emptyList())
         )
         Log.d("testo", result.recipes.toString())
    }
    private suspend fun getAllCategories() {
        val list = useCase.getAllTags()
        _uiState.emit(HomeViewState(isLoading = false, tags = list))
    }
}



package com.example.myapplication.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.domain.usecases.GetRecipesByMealUseCase
import com.example.myapplication.presentation.components.CustomSearchBar
import com.example.myapplication.presentation.components.MealSection
import com.example.myapplication.presentation.components.SearchScreenTopBar
import com.example.myapplication.presentation.intent.SearchIntent
import com.example.myapplication.presentation.viewmodels.SearchViewModel

val borderColor = Color(0xFFE6EBF2)
@Composable
@Preview
fun SearchScreen() {
    val viewModel: SearchViewModel = viewModel(
        factory = SearchViewModelFactory(
            GetRecipesByMealUseCase(AppContainer.repository)
        )
    )
    val state = viewModel.uiState.collectAsState().value
    LaunchedEffect(Unit){
        viewModel.onIntent(SearchIntent.GetAllRecipes)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
        SearchScreenTopBar(onBackClick = {})
        Spacer(modifier = Modifier.height(10.dp))
        CustomSearchBar(modifier = Modifier.padding(horizontal = 24.dp))
        Spacer(modifier = Modifier.height(10.dp))
        MealSection(viewModel = viewModel)
    }
    }




class SearchViewModelFactory(
    private val getRecipesByMealUseCase: GetRecipesByMealUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SearchViewModel(getRecipesByMealUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
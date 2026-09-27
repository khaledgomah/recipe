package com.example.myapplication.presentation.screens

import com.example.myapplication.presentation.components.CategorySection
import com.example.myapplication.presentation.components.HomeSlider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.myapplication.data.remote.RecipeApi
import com.example.myapplication.data.remote.RecipeApiImplementation
import com.example.myapplication.data.repository.RepositoryImplementation
import com.example.myapplication.domain.Repository
import com.example.myapplication.domain.usecases.AddRecipeUseCase
import com.example.myapplication.domain.usecases.*
import com.example.myapplication.presentation.components.PopularRecipes
import com.example.myapplication.presentation.components.WelcomePanner
import com.example.myapplication.presentation.intent.HomeIntent
import com.example.myapplication.presentation.viewmodels.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


val gray =Color(0xff97A2B0)
@Composable
fun HomeScreen() {

    val viewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory(
            AppContainer.recipeUseCases
        )
    )

    LaunchedEffect(Unit) {
        viewModel.onIntent(HomeIntent.GetAllRecipes)
        viewModel.onIntent(HomeIntent.GetAllCategories)
    }
    val state = viewModel.uiState.collectAsState().value
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            WelcomePanner(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        item {
            HomeSlider()
        }

        item {
            CategorySection( state = state, onRetry = {
                viewModel.onIntent(HomeIntent.GetAllCategories)
            })
        }

        item {
            PopularRecipes(
                state = state,
                onRetry = {
                    viewModel.onIntent(HomeIntent.GetAllRecipes)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


class HomeViewModelFactory(
    private val useCases: RecipeUseCases
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(useCases) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


object RecipeUseCasesProvider {

    fun provide(repository: Repository): RecipeUseCases {
        return RecipeUseCases(
            getAllRecipes = GetAllRecipesUseCase(repository),
            getSingleRecipe = GetSingleRecipeUseCase(repository),
            searchRecipes = SearchRecipesUseCase(repository),
            getRecipesByTag = GetRecipesByTagUseCase(repository),
            addRecipe = AddRecipeUseCase(repository),
            deleteRecipe = DeleteRecipeUseCase(repository),
            updateRecipe = UpdateRecipeUseCase(repository),
            getAllTags = GetAllTagsUseCase(repository)
        )
    }
}


object AppContainer {

    val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
    }

    private val recipeApi: RecipeApi =
        RecipeApiImplementation(client)

    val repository: Repository =
        RepositoryImplementation(recipeApi)

    val recipeUseCases: RecipeUseCases =
        RecipeUseCasesProvider.provide(repository)
}
package com.example.myapplication.presentation.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.domain.usecases.GetRecipesByMealUseCase
import com.example.myapplication.presentation.components.CategoryErrorState
import com.example.myapplication.presentation.components.CustomSearchBar
import com.example.myapplication.presentation.components.MealSection
import com.example.myapplication.presentation.components.RecipeCard
import com.example.myapplication.presentation.components.SearchScreenTopBar
import com.example.myapplication.presentation.components.SectionHeader
import com.example.myapplication.presentation.intent.SearchIntent
import com.example.myapplication.presentation.view_states.SearchViewState
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
        Spacer(modifier = Modifier.height(24.dp))
        MealRecipes(
            state = state,
            onRetry = {
                viewModel.onIntent(SearchIntent.GetAllRecipes)
            }
        )

    }
    }


@Composable
fun MealRecipes(state: SearchViewState, onRetry: () -> Unit) {
    val recipes = state.recipes
    Column(modifier = Modifier.height(400.dp))
    {
        SectionHeader(onSeeAll = {}, text = "Popular Recipes")

        if (state.isLoading) {
            RecipeMealLoadingShimmer()
        } else if (state.error != null) {
            CategoryErrorState(
                error = state.error,
                onRetry = onRetry
            )
        } else {
            LazyRow {
                items(recipes){
                        recipe -> RecipeCard(recipe = recipe)
                }
            }
        }
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



@Composable
fun RecipeMealLoadingShimmer() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition(label = "shimmer_transition")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer_anim"
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim, y = translateAnim)
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        items(4) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(brush)
            )
        }
    }
}
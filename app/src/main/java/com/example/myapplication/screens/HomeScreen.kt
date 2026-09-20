package com.example.myapplication.screens

import com.example.myapplication.components.CategorySection
import com.example.myapplication.components.HomeSlider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.components.RecipeCard
import com.example.myapplication.components.SectionHeader
import com.example.myapplication.components.WelcomePanner
import com.example.myapplication.data.recipes


val gray =Color(0xff97A2B0)
@Composable
fun HomeScreen() {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            WelcomePanner(modifier = Modifier.padding(horizontal = 16.dp))
        }
        item {
            HomeSlider()
        }
        item {
            CategorySection()
        }
        item {
            PopularRecipes()
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun PopularRecipes(){
    Column(modifier = Modifier.height(400.dp))
    {
        SectionHeader(onSeeAll = {}, text = "Popular Recipes")
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 200.dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(recipes) { recipe ->
                RecipeCard(recipe)
            }
        }
    }

}
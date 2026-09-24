package com.example.myapplication.presentation.screens

import com.example.myapplication.presentation.components.CategorySection
import com.example.myapplication.presentation.components.HomeSlider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.components.WelcomePanner


val gray =Color(0xff97A2B0)
@Composable
fun HomeScreen() {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item { Spacer(modifier = Modifier.height(16.dp)) }
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
        item { Spacer(modifier = Modifier.height(16.dp)) }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

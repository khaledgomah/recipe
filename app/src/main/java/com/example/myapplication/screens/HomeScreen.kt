package com.example.myapplication.screens

import Category
import CategorySection
import com.example.myapplication.components.HomeSlider
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.components.WelcomePanner

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
            HomeSlider()
            CategorySection()
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


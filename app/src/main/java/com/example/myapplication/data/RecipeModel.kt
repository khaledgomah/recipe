package com.example.myapplication.data

import com.example.myapplication.R


data class RecipeModel(
    val image: Int,
    val cal: Int,
    val time: String,
    val title: String,
    val isFav: Boolean
)


val recipes = listOf(
    RecipeModel(
        image = R.drawable.food,
        cal = 320,
        time = "20 min",
        title = "Chicken Salad",
        isFav = false
    ),
    RecipeModel(
        image = R.drawable.food,
        cal = 450,
        time = "35 min",
        title = "Beef Pasta",
        isFav = true
    ),
    RecipeModel(
        image = R.drawable.food,
        cal = 280,
        time = "15 min",
        title = "Healthy Breakfast",
        isFav = false
    ),
    RecipeModel(
        image = R.drawable.food,
        cal = 520,
        time = "40 min",
        title = "Grilled Chicken",
        isFav = true
    ),
    RecipeModel(
        image = R.drawable.food,
        cal = 390,
        time = "25 min",
        title = "Vegetable Rice",
        isFav = false
    )
)
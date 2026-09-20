package com.example.myapplication.data

import com.example.myapplication.R

data class CardModel(
    val name: String,
    val description: String,
    val image: Int,
    val timeMin: Int
)



val cards = listOf(
    CardModel(
        name = "Margherita Pizza",
        description = "Classic pizza with tomato sauce, mozzarella cheese and fresh basil.",
        image = R.drawable.burger,
        timeMin = 20
    ),
    CardModel(
        name = "Beef Burger",
        description = "Juicy beef patty with cheese, lettuce, tomato and special sauce.",
        image = R.drawable.burger,
        timeMin = 15
    ),
    CardModel(
        name = "Chicken Pasta",
        description = "Creamy pasta with grilled chicken cheese and herbs.",
        image = R.drawable.burger,
        timeMin = 25
    ),
    CardModel(
        name = "Grilled Chicken",
        description = "Tender grilled chicken served with vegetables and seasoned rice.",
        image = R.drawable.burger,
        timeMin = 30
    ),
    CardModel(
        name = "Caesar Salad",
        description = "Fresh lettuce with grilled chicken and Caesar dressing.",
        image = R.drawable.burger,
        timeMin = 10
    )
)

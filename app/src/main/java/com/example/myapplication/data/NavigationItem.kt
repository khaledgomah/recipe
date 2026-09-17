package com.example.myapplication.data

import androidx.compose.ui.graphics.painter.Painter

data class NavigationItem(
    val index: Int,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
)
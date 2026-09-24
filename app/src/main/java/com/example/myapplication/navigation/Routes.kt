package com.example.myapplication.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object OnboardingRoute: NavKey

@Serializable
data object Home: NavKey

@Serializable
data object Notifications: NavKey

@Serializable
data object Profile: NavKey

@Serializable
data object Search: NavKey

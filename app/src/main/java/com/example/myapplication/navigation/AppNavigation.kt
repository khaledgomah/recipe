package com.example.myapplication.navigation

import Home
import Notifications
import Profile
import Search
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.myapplication.screens.HomeScreen
import com.example.myapplication.screens.NotificationScreen
import com.example.myapplication.screens.ProfileScreen
import com.example.myapplication.screens.SearchScreen


@Composable
fun AppNavigation(paddingValues: PaddingValues,selectedTab: Int) {


    val homeBackStack = rememberNavBackStack(Home)

    val searchBackStack = rememberNavBackStack(Search)

    val notificationBackStack = rememberNavBackStack(Notifications)

    val profileBackStack = rememberNavBackStack(Profile)

    val currentBackStack = when (selectedTab) {
        0 -> homeBackStack
        1 -> searchBackStack
        2 -> notificationBackStack
        else -> profileBackStack
    }

    Box(modifier = Modifier.padding(paddingValues))
    {
        NavDisplay(
            backStack = currentBackStack,
            entryProvider = entryProvider {
                entry<Home> {
                    HomeScreen()
                }

                entry<Search> {

                    SearchScreen()
                }

                entry<Notifications> {
                    NotificationScreen()
                }

                entry<Profile> {
                    ProfileScreen()
                }

            }
        )

    }
}
package com.example.myapplication.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.myapplication.screens.HomeScreen
import com.example.myapplication.screens.NotificationScreen
import com.example.myapplication.screens.Onboarding
import com.example.myapplication.screens.ProfileScreen
import com.example.myapplication.screens.SearchScreen

@Composable
fun AppNavigation(
    paddingValues: PaddingValues,
    appBackStack: AppBackStack<NavKey>,
    onCompleteOnboarding: () -> Unit
) {
    Box(modifier = Modifier.padding(paddingValues)) {
        NavDisplay(
            backStack = appBackStack.backStack,
            onBack = { appBackStack.removeLast() },
            entryProvider = entryProvider {
                entry<OnboardingRoute> {
                    Onboarding(onClick = onCompleteOnboarding)
                }

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

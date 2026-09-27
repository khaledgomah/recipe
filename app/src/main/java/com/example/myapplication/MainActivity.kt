package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavKey
import com.example.myapplication.presentation.components.MyNavigationBar
import com.example.myapplication.presentation.navigation.AppBackStack
import com.example.myapplication.presentation.navigation.AppNavigation
import com.example.myapplication.presentation.navigation.Home
import com.example.myapplication.presentation.navigation.Notifications
import com.example.myapplication.presentation.navigation.OnboardingRoute
import com.example.myapplication.presentation.navigation.Profile
import com.example.myapplication.presentation.navigation.Search
import io.ktor.client.HttpClient


import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {

    private val client = HttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            var hasCompletedOnboarding by rememberSaveable {
                mutableStateOf(false)
            }

            val startRoute =
                if (hasCompletedOnboarding) {
                    Home
                } else {
                    OnboardingRoute
                }

            val appBackStack = remember {
                AppBackStack(startRoute)
            }

            AppRoot(
                appBackStack = appBackStack,
                onCompleteOnboarding = {
                    hasCompletedOnboarding = true
                    appBackStack.replaceAll(Home)
                }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        client.close()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRoot(
    appBackStack: AppBackStack<NavKey>,
    onCompleteOnboarding: () -> Unit
) {
    val currentRoute = appBackStack.backStack.lastOrNull()
    
    val topLevelRoutes = listOf(Home, Search, Notifications, Profile)
    val shouldShowBottomBar = currentRoute in topLevelRoutes

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            if (shouldShowBottomBar) {
                MyNavigationBar(
                    currentRoute = currentRoute ?: Home,
                    onNavigate = { newRoute ->
                        appBackStack.addTopLevel(newRoute)
                    }
                )
            }
        }
    ) { paddingValues ->
        AppNavigation(
            paddingValues = paddingValues,
            appBackStack = appBackStack,
            onCompleteOnboarding = onCompleteOnboarding
        )
    }
}

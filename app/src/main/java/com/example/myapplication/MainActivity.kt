package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.components.MyNavigationBar
import com.example.myapplication.navigation.AppNavigation
import com.example.myapplication.screens.Onboarding


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var onBoarding : Boolean by rememberSaveable { mutableStateOf(true) }
            if (onBoarding)
            {
                Onboarding(onClick ={onBoarding = false} )
            }
            else
            {
                AppRoot()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun AppRoot() {
    var selectedTab by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            MyNavigationBar(selectedTab,
                onChange = {newIndex->
                    selectedTab=newIndex
            })
        },
        //topBar ={ TopAppBar(title = { Text("Restaurant") })}
    ) { paddingValues ->
        AppNavigation(paddingValues,selectedTab)

    }
}


package com.example.myapplication.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey
import com.example.myapplication.R
import com.example.myapplication.navigation.Home
import com.example.myapplication.navigation.Notifications
import com.example.myapplication.navigation.Profile
import com.example.myapplication.navigation.Search

data class NavigationRouteItem(
    val route: NavKey,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
)

val notificationItemsList: List<NavigationRouteItem> = listOf(
    NavigationRouteItem(
        route = Home,
        selectedIcon = R.drawable.home_selected,
        unSelectedIcon = R.drawable.home
    ),
    NavigationRouteItem(
        route = Search,
        selectedIcon = R.drawable.search_selected,
        unSelectedIcon = R.drawable.search
    ),
    NavigationRouteItem(
        route = Notifications,
        selectedIcon = R.drawable.notification,
        unSelectedIcon = R.drawable.notification
    ),
    NavigationRouteItem(
        route = Profile,
        selectedIcon = R.drawable.profile_selected,
        unSelectedIcon = R.drawable.profile
    ),
)

@Composable
fun MyNavigationBar(
    currentRoute: NavKey,
    onNavigate: (NavKey) -> Unit
) {
    val navigationBarItemColor =
        NavigationBarItemColors(
            selectedIconColor = Color(0xff70B9BE),
            selectedTextColor = Color.Black,
            selectedIndicatorColor = Color.Transparent,
            unselectedIconColor = Color(0xff97A2B0),
            unselectedTextColor = Color.Transparent,
            disabledIconColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
        )
    Box {
        NavigationBar(
            containerColor = Color.White,
            modifier = Modifier.clip(
                shape = RoundedCornerShape(
                    topStart = 32f,
                    topEnd = 32f,
                    bottomStart = 0f,
                    bottomEnd = 0f,
                )
            )
        ) {
            notificationItemsList.forEach { item ->
                val isSelected = currentRoute == item.route
                val icon: Int = if (isSelected) item.selectedIcon else item.unSelectedIcon
                NavigationBarItem(
                    colors = navigationBarItemColor,
                    onClick = {
                        onNavigate(item.route)
                    },
                    icon = { Icon(painter = painterResource(icon), contentDescription = null) },
                    selected = isSelected,
                )
            }
        }

    }
}

@Preview
@Composable
fun PreviewMyNavigationBar() {
    MyNavigationBar(currentRoute = Home, onNavigate = {})
}

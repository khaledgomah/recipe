package com.example.myapplication.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

import com.example.myapplication.data.NavigationItem

@Composable
fun MyNavigationBar(selectedTab: Int,onChange:(new:Int)-> Unit) {
    val navigationBarItemColor =
        NavigationBarItemColors(
            selectedIconColor = Color(0xff70B9BE),
            selectedTextColor = Color.Black,
            selectedIndicatorColor= Color.Transparent,
            unselectedIconColor= Color(0xff97A2B0),
            unselectedTextColor= Color.Transparent,
            disabledIconColor= Color.Transparent,
            disabledTextColor= Color.Transparent,
        )
    Box {
        NavigationBar(
            containerColor = Color.White,
            modifier = Modifier.clip(
                shape =
                    RoundedCornerShape(
                        topStart = 32f,
                        topEnd = 32f,
                        bottomStart = 0f,
                        bottomEnd = 0f,

                        )
            )
        ) {
            notificationItemsList.forEach { item ->
                val isSelected = selectedTab == item.index
                val icon: Int = if (isSelected) item.selectedIcon else item.unSelectedIcon
                NavigationBarItem(
                    colors = navigationBarItemColor,
                    onClick = {
                        onChange(item.index)
                    },
                    icon = { Icon(painter = painterResource(icon), contentDescription = null) },
                    selected = isSelected,
                )
            }

        }
        Box(
            modifier = Modifier
                .size(width = 56.dp, height = 56.dp)
                .offset(y = (-32).dp)
                .clip(shape = CircleShape)
                .background(Color.Black)
                .align(alignment = Alignment.TopCenter)
            ,
            contentAlignment =Alignment.Center

        )
        {
            Image(painterResource(R.drawable.chef),null)
        }
    }
}



val notificationItemsList: List<NavigationItem> = listOf(
    NavigationItem(
        index = 0,
        selectedIcon = R.drawable.home_selected,
        unSelectedIcon = R.drawable.home
    )
    ,NavigationItem(
        index = 1,
        selectedIcon = R.drawable.search_selected,
        unSelectedIcon = R.drawable.search
    )
    ,NavigationItem(
        index = 2,
        selectedIcon = R.drawable.notification,
        unSelectedIcon = R.drawable.notification
    )
    ,NavigationItem(
        index = 3,
        selectedIcon = R.drawable.profile_selected,
        unSelectedIcon = R.drawable.profile
    ),
)


@Preview
@Composable
fun PreviewMyNavigationBar(){
    MyNavigationBar(1) {}
}
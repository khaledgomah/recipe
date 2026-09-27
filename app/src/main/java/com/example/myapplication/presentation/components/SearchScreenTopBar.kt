package com.example.myapplication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreenTopBar(modifier: Modifier = Modifier,onBackClick: () -> Unit): Unit {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color.White)
    ){
        IconButton(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp),
            onClick =onBackClick,
            colors = IconButtonColors(
                containerColor =Color.White,
                contentColor= Color.Black,
                disabledContainerColor= Color.Transparent,
                disabledContentColor= Color.Gray,
            ),
        ){
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,

            )
        }
    }
}


@Preview
@Composable
fun SearchScreenTopBarPreview() {
    SearchScreenTopBar(onBackClick = {})
}
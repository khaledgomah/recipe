package com.example.myapplication.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import com.example.myapplication.core.AppError
import com.example.myapplication.presentation.view_states.HomeViewState

@Composable
fun CategorySection(
    modifier: Modifier = Modifier,
    state: HomeViewState,
    onRetry: () -> Unit = {}
)
{
    var selectedCategory:Int by rememberSaveable { mutableIntStateOf(0) }

    if (state.isLoadingTags)
    {
        LoadingShimmer(modifier)
    }
    else if (state.tagsError != null)
    {
        Column(modifier) {
            SectionHeader(onSeeAll = {}, text = "Category")
            CategoryErrorState(
                error = state.tagsError,
                onRetry = onRetry
            )
        }
    }
    else
    {
        Column(modifier) {
            SectionHeader(onSeeAll = {}, text = "Category")
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding =PaddingValues(horizontal = 16.dp)
            ) {
                itemsIndexed(state.tags) {index,category ->
                    CustomChip(isSelected = selectedCategory == index, onClick = {
                        selectedCategory = index
                    }, category = category)
                }
            }
        }
    }
}

@Composable
fun CategoryErrorState(
    error: AppError,
    modifier: Modifier = Modifier,
    onRetry: () -> Unit
) {
    val icon = when (error) {
        AppError.NoInternet -> Icons.Default.Warning
        AppError.ServerError -> Icons.Default.Warning
        AppError.Unauthorized -> Icons.Default.Lock
        is AppError.BackendError -> Icons.Default.Info
        AppError.Unknown -> Icons.Default.Info
    }
    
    val message = when (error) {
        AppError.NoInternet -> "No internet connection"
        AppError.ServerError -> "Server error occurred"
        AppError.Unauthorized -> "You are not authorized"
        is AppError.BackendError -> error.message
        AppError.Unknown -> "An unknown error occurred"
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Error Icon",
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = message,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyMedium
        )
        TextButton(onClick = onRetry) {
            Text("Try Again")
        }
    }
}

@Composable
fun LoadingShimmer(modifier: Modifier = Modifier) {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition(label = "shimmer_transition")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer_anim"
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim, y = translateAnim)
    )

    Column(modifier = modifier) {
        SectionHeader(onSeeAll = {}, text = "Category")
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            repeat(5) {
                Box(
                    modifier = Modifier
                        .height(36.dp)
                        .width(80.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(brush)
                )
            }
        }
    }
}


package com.example.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.data.RecipeModel
import com.example.myapplication.screens.gray

@Composable
fun RecipeCard(recipe: RecipeModel)
{
    Column(modifier = Modifier
        .width(200.dp)
        .clip(shape = RoundedCornerShape(16.dp))
        .background(Color.White)
        .padding(16.dp)
    ) {
        Image(
            painter = painterResource(recipe.image)
            , modifier = Modifier.fillMaxWidth()
            , contentDescription = null,
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(12.dp))
        Text(recipe.title)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.calories),
                contentDescription = null,
                tint = gray)
            Spacer(Modifier.width(4.dp))
            Text("${recipe.cal} Kcal", style = TextStyle(color = gray))
            Spacer(Modifier.width(8.dp))
            Box(modifier = Modifier
                .size(8.dp)
                .clip(shape = CircleShape)
                .background(gray)
            ){

            }
            Spacer(Modifier.width(8.dp))
            Icon(
                tint= gray,
                painter = painterResource(R.drawable.time),
                contentDescription = null)
            Spacer(Modifier.width(4.dp))
            Text("${recipe.time} Min", style = TextStyle(color = gray))
        }

    }
}


package com.example.myapplication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.screens.secondary

@Composable
@Preview
fun WelcomePanner(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
    )
    {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row {
                Icon(painter = painterResource(R.drawable.sun),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color(secondary))
                Spacer(Modifier.width(4.dp))
                Text("Good Morning", style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ))
            }
            Text("Alena Saroyan", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ))
        }
        Icon(painter = painterResource(R.drawable.buy),
            contentDescription = null,
            modifier = Modifier.size(23.dp),)

    }
}
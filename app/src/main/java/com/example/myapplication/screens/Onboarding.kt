package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

val secondary: Long = 0xff70B9BE
@Composable
fun Onboarding(onClick: ()-> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(secondary)).padding(16.dp)
    ){
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.onboarding),
            contentDescription = null
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {

            Text("Help your path to health goals with happiness", style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center

                ))
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor= Color.Black
                ),
               shape = RoundedCornerShape(16.dp)
                ) {
                Text("Login",style = TextStyle(
                        fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ))
            }
            TextButton(onClick = onClick,
                modifier = Modifier.fillMaxWidth()
                ) {
                Text("Create new Account", style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ))
            }
            Spacer(modifier = Modifier.height(70.dp))

        }
    }
}
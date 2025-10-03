package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.example.weatherapp.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable

fun CurrentWeatherfun() {
    Spacer(modifier = Modifier.height(16.dp))
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFD6EAF8)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.currentimg),
            contentDescription = "Weather icon",
            modifier = Modifier.size(80.dp),

            )
        //Weather info
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
        {

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Sunny")
            Text(text = "22°C")
            Text(text = "Feels like 18°C")
            Text(text = "Wind Sw 14 kph")
        }
    }

}
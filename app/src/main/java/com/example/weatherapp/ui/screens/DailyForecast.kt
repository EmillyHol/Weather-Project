package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.weatherapp.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.ForecastDay
import com.example.weatherapp.services.MainViewModel


@Composable
fun DailyForecastScreen(mainViewModel: MainViewModel) {
    val weather by mainViewModel.weather.collectAsState()
    val forecastDays = weather?.forecast?.forecastday
    // Vertical list for all forecast cards
    if (forecastDays != null) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(forecastDays) { day ->
                ForecastCard(day)
            }
        }
    }
}



    @Composable
    fun ForecastCard(day: ForecastDay) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = day.date,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                val conditionText = day.day.condition.text.lowercase()
                val icon = when (conditionText) {
                    "rainy" -> R.drawable.rainimg
                    "partly cloudy" -> R.drawable.pcloudyimg
                    else -> R.drawable.sunny
                }

                Image(
                    painter = painterResource(icon),
                    contentDescription = day.day.condition.text,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${day.day. maxtempC}°C / ${day.day.mintempC}°C",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )

                Text(text = day.day.condition.text,
                    fontSize = 14.sp
                )

                Text(
                    text = "${day.day.maxWindKph} km/h (${day.day.chanceOfRain} mm)",
                    fontSize = 13.sp
                )
                Text(
                        text = "${day.day.windDir} at ${day.day.maxWindKph} Km/h — ${day.day.avgHumidity}%",
                    fontSize = 13.sp
                )
            }
        }
    }

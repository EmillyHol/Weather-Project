package com.example.weatherapp

import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.Current
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel(){
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()
    init {
      val current = Current(
          condition = "Sunny",
          temperature = 22.5,
          precipitationType = "Feels like",
          precipitationAmount = 18.0,
          windDirection = "SW",
          windSpeed = 14.6,
      )
        val forecast = listOf(
            Forecast("2025-10-03","Partly Cloudy", 30.0,19.0,"Chance of rain", 0.0,5, "NE",10.0,40) ,
            Forecast("2025-10-04","Rainy", 20.0,18.0,"Chance of rain", 70.0,5, "NS",9.0,80),
            Forecast("2025-10-05","Sunny", 31.0,27.0,"None", 0.0,0, "SW",14.0,20)
        )
        _weather.value = Weather(current, forecast)

    }

}
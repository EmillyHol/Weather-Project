package com.example.weatherapp.services

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.weatherapp.models.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainViewModel : ViewModel(){
    private val _weather = MutableStateFlow<WeatherResponse?>(null)
    val weather = _weather.asStateFlow()

    // Retrofit instance
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // initialize the interface (service)
    private val weatherService: WeatherService = retrofit.create(WeatherService::class.java)

    fun loadWeatherByCoords(lat: Double, lon: Double){
        viewModelScope.launch {
            try {
                val response = weatherService.getWeather(
                    apiKey = "24294987f58e474b8d402314252510",
                    location = "Halifax",
                    days = 14,
                    aqi = "yes",
                    alerts = "yes"
                )
                _weather.value = response
            } catch (e: Exception) {
                Log.e("WeatherApp", "Error fetching weather", e)
            }
        }
    }

}




package com.example.weatherapp.services

interface WeatherService {
    fun getCurrentWeather(): String
    fun getForecast(): String
}
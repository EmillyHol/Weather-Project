package com.example.weatherapp.models

data class Weather (
    val date: String? = null,
    val condition: String,
    val temperature: String? = null,
    val feelsLike: String? = null,
    val tempHigh: String? = null,
    val tempLow: String? = null,
    val wind: String,
    val precipitation: String? = null,
    val humidity: String? = null
)
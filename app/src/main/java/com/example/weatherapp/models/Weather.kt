package com.example.weatherapp.models
import com.google.gson.annotations.SerializedName


data class WeatherResponse(
    val location: Location,
    val current: Current
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    @SerializedName("tz_id") val tzId: String,
    val localtime: String
)

data class Current(
    @SerializedName("temp_c") val tempC: Double,
    @SerializedName("temp_f") val tempF: Double,
    @SerializedName("is_day") val isDay: Int,
    val condition: Condition,
    @SerializedName("wind_mph") val windMph: Double,
    @SerializedName("wind_kph") val windKph: Double,
    @SerializedName("wind_dir") val windDir: String,
    @SerializedName("feelslike_c") val feelsLikeC: Double,
    @SerializedName("pressure_mb") val pressureMb: Double,
    @SerializedName("precip_mm") val precipMm: Double,
    val cloud: Int
)

data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)

data class Forecast(val forecastday: List<ForecastDay>)

data class ForecastDay(
    val date: String,
    val day: Day
)

data class Day(
    @SerializedName("maxtem_c") val maxtempC: Double,
    @SerializedName("mintemp_c") val mintempC: Double,
    @SerializedName("avgtemp_c") val avgtempC: Double,
    val condition: Condition
)

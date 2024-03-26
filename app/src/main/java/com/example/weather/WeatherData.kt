package com.example.weather


data class Weather(
    val name : String,
    val currentWeather : CurrenyWeather,
    val hourlyWeather : List<HourlyWeather>,
    val tenDaysWeather : List<TenDaysWeather >
    )

data class CurrenyWeather(
    val temperature: Int,
    val maxTemperature : Int,
    val minTemperature : Int,
    val weatherStatus : String,
    val airQualityIndex : Int
)


data class HourlyWeather(
    val time : String,
    val maxtemprature :Int,
    val mintemprature: Int,
    val weatherStatus: String
)

data class TenDaysWeather(
    val date : String,
    val maxtemprature: String,
    val mintemprature: String,
    val weatherStatus: String
)

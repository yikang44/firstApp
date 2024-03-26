package com.example.weather.data

import android.content.Context
import com.google.gson.Gson
import android.content.ContentValues
import com.example.weather.Weather

class WeatherDataManger(context: Context) {

    private val dbHelper = WeatherDBHelper(context)

    fun insertWeatherDataFromJson(jsonString : String){
        val db = dbHelper.writableDatabase
        val gson = Gson()
        val weatherDataList = gson.fromJson(jsonString, Weather::class.java)


    }
}
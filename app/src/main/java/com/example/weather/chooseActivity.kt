package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class chooseActivity : AppCompatActivity() {

    lateinit var DayWeatherAdapter : DayWeatherAdapter
    lateinit var menu : RecyclerView
    lateinit var DayList : ArrayList<DayWeather>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tendays)
        init()
        val actionBar = supportActionBar
        actionBar?.title = getString(R.string._10_days_weather)
    }

    private fun init(){
        menu = findViewById(R.id.menu)
        menu.setHasFixedSize(true)
        menu.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        DayList = ArrayList()

        AddToDoList()

        DayWeatherAdapter = DayWeatherAdapter(DayList)
        menu.adapter = DayWeatherAdapter
    }

    private  fun AddToDoList() {
        DayList.add(DayWeather(R.drawable.rain, getString(R.string.Tomorrow),getString(R.string.rain), "32°", "20°"))
        DayList.add(DayWeather(R.drawable.sunny, getString(R.string.sun),getString(R.string.Sunny),"32°", "20°"))
        DayList.add(DayWeather(R.drawable.cloud_black, getString(R.string.mon),getString(R.string.cloud), "32°", "20°"))
        DayList.add(DayWeather(R.drawable.rain, getString(R.string.tue),getString(R.string.Rain),"32°", "20°"))
        DayList.add(DayWeather(R.drawable.rain, getString(R.string.wed),getString(R.string.rain1),"32°", "20°"))
        DayList.add(DayWeather(R.drawable.rain, getString(R.string.thu),getString(R.string.rain2),"32°", "20°"))
        DayList.add(DayWeather(R.drawable.rain, getString(R.string.fri),getString(R.string.rain3),"32°", "20°"))
        DayList.add(DayWeather(R.drawable.rain, getString(R.string.sat),getString(R.string.rain4),"32°", "20°"))
        DayList.add(DayWeather(R.drawable.rain, getString(R.string.Sun),getString(R.string.rain5),"32°", "20°"))
        DayList.add(DayWeather(R.drawable.rain, getString(R.string.Mon),getString(R.string.rain6),"32°", "20°"))
    }
}
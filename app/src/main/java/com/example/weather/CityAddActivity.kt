package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CityAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_add)


        val action = supportActionBar
        action?.title = getString(R.string.add_city)
    }
}
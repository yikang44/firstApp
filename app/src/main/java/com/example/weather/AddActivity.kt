package com.example.weather

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.JsonObject

class AddActivity : AppCompatActivity() {

    private lateinit var add : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val action = supportActionBar
        action?.title = getString(R.string.manger_city)
        add = findViewById(R.id.add)

        add.setOnClickListener {
            val intent = Intent(this, CityAddActivity::class.java)
            startActivity(intent)
        }
    }

}
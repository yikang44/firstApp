package com.example.weather


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.nio.charset.Charset

import java.util.Locale



class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var recyclerView: RecyclerView
    lateinit var weatherList: ArrayList<hourWeather>
    lateinit var weatheradpter : weatherAdpter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoadLocale()
        setContentView(binding.root)

        init()
        linksetup()
        val actionBar = supportActionBar
        actionBar?.title = ""

        val jsonString = readJsonFromAssets("weather.json")
        val gson = Gson()
        val weatherData = gson.fromJson(jsonString, Weather::class.java)
        binding.temp.text = weatherData.currentWeather.temperature.toString()
        binding.math.text = weatherData.currentWeather.maxTemperature.toString()
        binding.mat.text = weatherData.currentWeather.minTemperature.toString()
    }

    private fun readJsonFromAssets(fileName : String): String? {
        val inputStream = assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        return String(buffer, Charset.defaultCharset())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.add -> {
                val intent = Intent(this, AddActivity::class.java)
                startActivity(intent)
                return true
            }R.id.map ->{
                val intent = Intent(this, MapActivity::class.java)
                startActivity(intent)
                return true
            }R.id.lang ->{
                showSelectLanguage()
                return true
            }else ->  super.onOptionsItemSelected(item)
        }

    }


    private fun showSelectLanguage() {
        val supportLanguage = arrayOf("English", "French", "Chinese", "Italian", "Japanese")

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Select Language")

        alertDialogBuilder.setSingleChoiceItems(supportLanguage, -1){ dialog, which ->
            if (which == 0){
                setLanguage("en")
                recreate()
            }else if (which == 1){
                setLanguage("fr")
                recreate()
            }else if (which == 2){
                setLanguage("zh")
                recreate()
            }else if (which == 3){
                setLanguage("it")
                recreate()
            }else if (which == 4){
                setLanguage("ja")
                recreate()
            }
            dialog.dismiss()
        }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
    }

    private fun setLanguage(language: String?) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.locale = locale
        baseContext.resources.updateConfiguration(configuration, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("Language", language)
        editor.apply()
    }

    private fun LoadLocale() {
        val sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val mLanguage = sharedPreferences.getString("Language","")
        setLanguage(mLanguage)
    }


    private fun linksetup() {
       val daylink : TextView = findViewById(R.id.daylink)

        daylink.setOnClickListener {
            val intent = Intent(this, chooseActivity::class.java)
            startActivity(intent)
        }

    }


    private fun init(){
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        weatherList = ArrayList()
        weatheradpter = weatherAdpter(weatherList)
        recyclerView.adapter = weatheradpter
    }

}

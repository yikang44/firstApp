package com.example.weather.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class WeatherDBHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Weather.db"
    }

    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${WeatherContract.WeatherEntry.TABLE_NAME} (" +
                "${WeatherContract.WeatherEntry._ID} INTEGER PRIMARY KEY," +
                "${WeatherContract.WeatherEntry.COLUMN_CITY} TEXT, " +
                "${WeatherContract.WeatherEntry.COLUMN_TEMPERATURE} INTEGER, " +
                "${WeatherContract.WeatherEntry.COLUMN_MAX_TEMPERATURE} INTEGER, " +
                "${WeatherContract.WeatherEntry.COLUMN_MIN_TEMPERATURE} INTEGER, " +
                "${WeatherContract.WeatherEntry.COLUMN_WEATHER_STATUS} INTEGER, " +
                "${WeatherContract.WeatherEntry.COLUMN_AIR_QUALITY_INDEX} INTEGER ) "

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${WeatherContract.WeatherEntry.TABLE_NAME}"
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}

object WeatherContract {
    object WeatherEntry : BaseColumns {
        const val TABLE_NAME = "Weather"
        const val _ID = BaseColumns._ID
        const val COLUMN_CITY = "city"
        const val COLUMN_TEMPERATURE = "temperature"
        const val COLUMN_MAX_TEMPERATURE = "max_temperature"
        const val COLUMN_MIN_TEMPERATURE = "min_temperature"
        const val COLUMN_WEATHER_STATUS = "weatherStatus"
        const val COLUMN_AIR_QUALITY_INDEX = "airQualityIndex"
    }
}

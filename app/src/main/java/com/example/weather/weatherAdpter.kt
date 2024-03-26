package com.example.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class weatherAdpter(private val weatherList : List<hourWeather>) :
    RecyclerView.Adapter<weatherAdpter.weatherViewHolder>(){

    class weatherViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val dayhour : TextView = itemView.findViewById(R.id.hour)
        val weather : ImageView = itemView.findViewById(R.id.weather)
        val mintemp : TextView = itemView.findViewById(R.id.min)
        val maxtemp : TextView = itemView.findViewById(R.id.max)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): weatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return weatherViewHolder(view)
    }


    override fun onBindViewHolder(holder: weatherViewHolder, position: Int)  {
        val weather = weatherList[position]
        holder.weather.setImageResource(weather.weatherImage)
        holder.dayhour.text = weather.dayHour
        holder.mintemp.text = weather.mintemp
        holder.maxtemp.text = weather.maxtemp
    }
    override fun getItemCount(): Int {
        return weatherList.size
    }
}

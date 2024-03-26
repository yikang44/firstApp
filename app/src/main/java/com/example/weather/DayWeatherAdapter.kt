package com.example.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DayWeatherAdapter(private val DayList : List<DayWeather>):
RecyclerView.Adapter<DayWeatherAdapter.DayViewHolder>(){
    class DayViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val Weather : ImageView = itemView.findViewById(R.id.Weather)
        val day : TextView = itemView.findViewById(R.id.day)
        val Max : TextView = itemView.findViewById(R.id.max_temp)
        val Min : TextView = itemView.findViewById(R.id.min_temp)
        val typer : TextView = itemView.findViewById(R.id.typer)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): DayViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.horizontal, parent, false)
        return  DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayWeatherAdapter.DayViewHolder, position: Int) {
        val day = DayList[position]
        holder.Weather.setImageResource(day.weather)
        holder.day.text = day.day
        holder.Max.text = day.max_temp
        holder.Min.text = day .min_temp
        holder.typer.text = day.type
    }

    override fun getItemCount(): Int {
        return  DayList.size
    }
}
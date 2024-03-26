package com.example.weather

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class cityAdapter(private val activity: Activity, private val context: Context,
                  private val name: ArrayList<String>,
                  private val temper: ArrayList<String>,
                  private val type: ArrayList<String>):
    RecyclerView.Adapter<cityAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view:View = inflater.inflate(R.layout.list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = name[position]
        holder.tempter.text = temper[position]
        holder.type.text = type[position]

        holder.layout.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("name", name[position])
            intent.putExtra("temp", temper[position])
            intent.putExtra("type", type[position])
            activity.startActivityForResult(intent, 1)
        }
    }

    override fun getItemCount(): Int {
        return name.size
    }

    inner class MyViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.name)
        val tempter : TextView = itemView.findViewById(R.id.temper)
        val type : TextView = itemView.findViewById(R.id.type)
        val layout : LinearLayout = itemView.findViewById(R.id.layout)
    }
}


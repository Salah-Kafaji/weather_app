package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.WeatherViewItemBinding
import com.example.weatherapp.model.response.WeatherIntervals
import com.example.weatherapp.util.toDate
import com.example.weatherapp.util.toFormattedString


class WeatherDataAdapter (private val list: List<WeatherIntervals>): RecyclerView.Adapter<WeatherDataAdapter.WeatherViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_view_item, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentValue = list[position]
        holder.binding.apply {
            valueTemperature.text = currentValue.field.temperatureValue.toString()
            valueTime.text  = currentValue.timeStep?.toDate()?.toFormattedString("HH:mm")
        }
    }

    override fun getItemCount(): Int = list.size

    class WeatherViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem){
        val binding = WeatherViewItemBinding.bind(viewItem)
    }

}



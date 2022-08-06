package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.DayWeatherItemBinding
import com.example.weatherapp.model.response.WeatherIntervals
import com.example.weatherapp.util.toDate
import com.example.weatherapp.util.toFormattedString

class DayWeatherDataAdapter(private val list: List<WeatherIntervals>): RecyclerView.Adapter<DayWeatherDataAdapter.DayWeatherViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayWeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_weather_item, parent, false)
        return DayWeatherViewHolder(view)
    }
    override fun onBindViewHolder(holder: DayWeatherViewHolder, position: Int) {
        val currentValue = list[position]
        holder.binding.apply {
            valueTemperature.text = currentValue.temperature.temperatureValue.toString()+"C"
            valueTime.text  = currentValue.timeStep?.toDate()?.toFormattedString("HH:mm")
        }
    }

    override fun getItemCount(): Int = list.size

    class DayWeatherViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem){
        val binding = DayWeatherItemBinding.bind(viewItem)
    }


}
package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.WeatherViewItemBinding
import com.example.weatherapp.model.response.WeatherIntervals

class WeatherDataAdapter (private val list: List<WeatherIntervals>): RecyclerView.Adapter<WeatherDataAdapter.VideoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_view_item, parent, false)
        return VideoViewHolder(view)
    }
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val currentValue = list[position]
        holder.binding.apply {
            valueTemperature.text = currentValue.temperature.temperatureValue.toString()
        }
    }

    override fun getItemCount(): Int = list.size

    class VideoViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem){
        val binding = WeatherViewItemBinding.bind(viewItem)
    }

}
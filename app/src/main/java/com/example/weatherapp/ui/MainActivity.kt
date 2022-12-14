package com.example.weatherapp.ui

import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.DataManager
import com.example.weatherapp.ui.adapter.DayWeatherDataAdapter
import com.example.weatherapp.ui.adapter.WeatherDataAdapter
import com.example.weatherapp.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    private val dataManager  =  DataManager()
    override fun setUp() {
        binding.apply {
            dataManager.setStartSignal { isCollected ->
                if (isCollected){
                    val adapter = WeatherDataAdapter(dataManager.getWeatherFeeds())
                    val dayAdapter = DayWeatherDataAdapter(dataManager.getDayWeatherFeeds())
                    runOnUiThread{
                        binding.weatherRecycleView.adapter = adapter
                        binding.dayWeatherRecycleView.adapter = dayAdapter
                    }
                }
            }
        }
    }

}
package com.example.weatherapp.model

import com.example.weatherapp.model.network.Client
import com.example.weatherapp.model.response.WeatherIntervals


class DataManager: DataManagerStarter {
        fun getWeatherFeeds(): MutableList<WeatherIntervals> {
                return Client.weatherFeeds
        }

        fun getDayWeatherFeeds(): MutableList<WeatherIntervals> {
                return Client.dayWeatherFeeds
        }


        override fun setStartSignal(onDataCollected: (isCollected: Boolean) -> Unit ) {
                Client.getRequestedWeather(onDataCollected)
        }
}
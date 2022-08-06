package com.example.weatherapp.model.response

import com.google.gson.annotations.SerializedName

data class WeatherData (
        @SerializedName("timelines") val timeLine: List<TimeLine>?
    )
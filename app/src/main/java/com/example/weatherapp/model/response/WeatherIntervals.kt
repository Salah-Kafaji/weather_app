package com.example.weatherapp.model.response

import com.google.gson.annotations.SerializedName

data class WeatherIntervals(
    @SerializedName("startTime") val timeStep: String?,
    @SerializedName("values") val temperature: Temperature
)
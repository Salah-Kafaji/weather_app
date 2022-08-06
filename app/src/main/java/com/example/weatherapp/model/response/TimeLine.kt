package com.example.weatherapp.model.response

import com.google.gson.annotations.SerializedName

data class TimeLine (
    @SerializedName("timestep") val timeStep: String?,
    @SerializedName("endTime") val endTime: String?,
    @SerializedName("startTime") val startTime: String?,
    @SerializedName("intervals") val interval: List<WeatherIntervals>?
)
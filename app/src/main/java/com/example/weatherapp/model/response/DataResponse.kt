package com.example.weatherapp.model.response

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("data") val weatherData: WeatherData
)
package com.example.weatherapp.model.response

import com.google.gson.annotations.SerializedName

data class Temperature(
    @SerializedName("temperature") val temperatureValue: String?
    )
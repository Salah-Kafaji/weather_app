package com.example.weatherapp.model.response

import com.google.gson.annotations.SerializedName

data class Field(
    @SerializedName("temperature") val temperatureValue: String?,
    @SerializedName("humidity") val humidityValue: String?,
    @SerializedName("windSpeed") val windSpeedValue: String?,
    @SerializedName("cloudCover") val cloudCoverValue: String?,
    @SerializedName("uvIndex") val uvIndexValue: String?
    )
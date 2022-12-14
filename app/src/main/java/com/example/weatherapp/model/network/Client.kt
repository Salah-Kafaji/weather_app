package com.example.weatherapp.model.network

import android.util.Log
import com.example.weatherapp.model.response.DataResponse
import com.example.weatherapp.model.response.WeatherIntervals
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

object Client {
    private val weatherApiClint = OkHttpClient()
    val weatherFeeds = mutableListOf<WeatherIntervals>()
    val dayWeatherFeeds = mutableListOf<WeatherIntervals>()
    fun getRequestedWeather(onDataCollected :(isCollected: Boolean) -> Unit) {
         val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.tomorrow.io")
            .addPathSegment("v4")
            .addPathSegment("timelines")
            .addQueryParameter("location","32.031914,44.322999")
            .addQueryParameter("fields","temperature")
            .addQueryParameter("fields","humidity")
            .addQueryParameter("fields","windSpeed")
            .addQueryParameter("fields","cloudCover")
            .addQueryParameter("fields","uvIndex")
            .addQueryParameter("units","metric")
            .addQueryParameter("timesteps","1h")
            .addQueryParameter("startTime","now")
            .addQueryParameter("timezone","Asia/Baghdad")
            .addQueryParameter("apikey","DAShOSPYbnLLJUhJs4KOjqnfyELN6jVR")
            .build()

        val request = Request.Builder().url(url).build()
        weatherApiClint.newCall(request).enqueue( object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("CLINT_FAIL","fail: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { jsonString ->
                    val responseResult = Gson().fromJson(jsonString, DataResponse::class.java )
                    responseResult.weatherData.timeLine!![0].interval?.forEach { interval ->
                        weatherFeeds.add(interval)
                    }
                    dayWeatherFeeds.add(responseResult.weatherData.timeLine[0].interval!![0])
                }
                onDataCollected(true)
            }
        })
     }
}
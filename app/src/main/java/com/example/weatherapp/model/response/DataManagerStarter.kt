package com.example.weatherapp.model.response

interface DataManagerStarter {
    fun setStartSignal(onDataCollected :(isCollected: Boolean) -> Unit)
}
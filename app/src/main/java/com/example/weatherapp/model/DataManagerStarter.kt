package com.example.weatherapp.model

interface DataManagerStarter {
    fun setStartSignal(onDataCollected :(isCollected: Boolean) -> Unit)
}
package com.example.weatherapp.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Date.toFormattedString(format: String): String {
    val dateFormatter = SimpleDateFormat(format, Locale.US)
    return dateFormatter.format(this)
}

fun String.toDate(inputFormat: String = "yyyy-MM-dd'T'HH:mm:ss"): Date? {
    val dateFormatter = SimpleDateFormat(inputFormat, Locale.US)
    return try {
        dateFormatter.parse(this)
    } catch (e: ParseException) {
        null
    }
}

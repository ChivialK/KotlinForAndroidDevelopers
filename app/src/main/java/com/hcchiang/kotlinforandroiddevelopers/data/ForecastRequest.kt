package com.hcchiang.kotlinforandroiddevelopers.data

import com.google.gson.Gson
import java.net.URL

/**
 * Request json weather data from OpenWeatherMap API
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 8: Retrieving data from API
 * Chapter 10: Parsing data {@link ResponseClasses.kt}
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
class ForecastRequest(private val zipCode: String) {

    companion object {
        private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private const val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private const val COMPLETE_URL = "$URL&APPID=$APP_ID&zip="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}
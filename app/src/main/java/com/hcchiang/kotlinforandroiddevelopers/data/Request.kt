package com.hcchiang.kotlinforandroiddevelopers.data

import android.util.Log
import java.net.URL

/**
 * Request json weather data from OpenWeatherMap API
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 8: Retrieving data from API
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
class Request(private val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}
package com.hcchiang.kotlinforandroiddevelopers.domain.model

/**
 * Basic data class
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 10: Parsing data
 * Chapter 11: Operator overloading
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    // Chapter 11: Operator overloading
    val size: Int get() = dailyForecast.size
    operator fun get(position: Int): Forecast = dailyForecast[position]
}

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)
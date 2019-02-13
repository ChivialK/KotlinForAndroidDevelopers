package com.hcchiang.kotlinforandroiddevelopers.domain.model

/**
 * Basic data class
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 10: Parsing data
 * Chapter 11: Operator overloading
 * Chapter 12: Making the forecast list clickable
 * Chapter 14: Visibility modifiers
 * Chapter 19: Saving and requesting data from database
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
data class ForecastList(val id: Long, val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {

    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]
}

data class Forecast(val date: Long, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)

package com.hcchiang.kotlinforandroiddevelopers.domain.mappers

import com.hcchiang.kotlinforandroiddevelopers.data.server.Forecast
import com.hcchiang.kotlinforandroiddevelopers.data.server.ForecastResult
import com.hcchiang.kotlinforandroiddevelopers.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.hcchiang.kotlinforandroiddevelopers.domain.model.Forecast as ModelForecast

/**
 * Convert data
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 10: Parsing data
 * Chapter 12: Making the forecast list clickable
 * Chapter 14: Visibility modifiers
 * Chapter 19: Saving and requesting data from database
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        // 循環這個集合並且返回一個轉換後的List
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}
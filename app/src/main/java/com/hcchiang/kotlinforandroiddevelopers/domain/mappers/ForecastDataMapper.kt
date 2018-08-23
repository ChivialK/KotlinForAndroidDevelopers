package com.hcchiang.kotlinforandroiddevelopers.domain.mappers

import com.hcchiang.kotlinforandroiddevelopers.data.Forecast
import com.hcchiang.kotlinforandroiddevelopers.data.ForecastResult
import com.hcchiang.kotlinforandroiddevelopers.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.hcchiang.kotlinforandroiddevelopers.domain.model.Forecast as ModelForecast

/**
 * Convert data
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 10: Parsing data
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList
        = ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        // 循環這個集合並且返回一個轉換後的List
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}
package com.hcchiang.kotlinforandroiddevelopers.data.db

import com.hcchiang.kotlinforandroiddevelopers.domain.model.Forecast
import com.hcchiang.kotlinforandroiddevelopers.domain.model.ForecastList

/**
 *
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 19: Saving and requesting data from database
 *
 * Created on 2018/8/29. Copyright © 2017 All rights reserved
 */
class DbDataMapper {

    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForeCast(id, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }

    fun convertToDomain(forecast: CityForeCast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

    private fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(date, description, high, low, iconUrl)
    }
}
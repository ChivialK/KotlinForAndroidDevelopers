package com.hcchiang.kotlinforandroiddevelopers.data.db

import com.hcchiang.kotlinforandroiddevelopers.domain.model.ForecastList
import com.hcchiang.kotlinforandroiddevelopers.extension.clear
import com.hcchiang.kotlinforandroiddevelopers.extension.parseList
import com.hcchiang.kotlinforandroiddevelopers.extension.parseOpt
import com.hcchiang.kotlinforandroiddevelopers.extension.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Request and Query database data
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 19: Saving and requesting data from database
 *
 * Created on 2018/8/29. Copyright © 2017 All rights reserved
 */
class ForecastDb(private val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 private val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForeCast(HashMap(it), dailyForecast) }

        if(city != null) dataMapper.convertToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }

}
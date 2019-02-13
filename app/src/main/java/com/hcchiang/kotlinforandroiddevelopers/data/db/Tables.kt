package com.hcchiang.kotlinforandroiddevelopers.data.db

/**
 * Database tables
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 17: Creating an SQLiteOpenHelper
 *
 * Created on 2018/8/29. Copyright © 2017 All rights reserved
 */
object CityForecastTable {
    const val NAME = "CityForecast"
    const val ID = "_id"
    const val CITY = "city"
    const val COUNTRY = "country"
}

object DayForecastTable {
    const val NAME = "DayForecast"
    const val ID = "_id"
    const val DATE = "date"
    const val DESCRIPTION = "description"
    const val HIGH = "high"
    const val LOW = "low"
    const val ICON_URL = "iconUrl"
    const val CITY_ID = "cityId"
}
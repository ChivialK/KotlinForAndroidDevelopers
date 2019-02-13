package com.hcchiang.kotlinforandroiddevelopers.data.db

/**
 * Create map to reflect data to database
 *
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 19: Saving and requesting data from database
 *
 * Created on 2018/8/29. Copyright © 2017 All rights reserved
 */

/**
 * 1.Reflect map value to the new map by key
 * ※key string must be the same as in database
 *
 * 2. add domain(DayForecast) list data to the new map
 */
class CityForeCast(val map: MutableMap<String, Any?>, val dailyForecast: List<DayForecast>) {
    var _id: Long by map
    var city: String by map
    var country: String by map

    constructor(id: Long, city: String, country: String, dailyForecast: List<DayForecast>)
            : this(HashMap(), dailyForecast) {
        this._id = id
        this.city = city
        this.country = country
    }
}

class DayForecast(var map: MutableMap<String, Any?>) {
    var _id: Long by map
    var date: Long by map
    var description: String by map
    var high: Int by map
    var low: Int by map
    var iconUrl: String by map
    var cityId: Long by map

    constructor(date: Long, description: String, high: Int, low: Int, iconUrl: String, cityId: Long)
            : this(HashMap()) {

        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}

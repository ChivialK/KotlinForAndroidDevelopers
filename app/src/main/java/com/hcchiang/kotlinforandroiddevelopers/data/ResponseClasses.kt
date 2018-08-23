package com.hcchiang.kotlinforandroiddevelopers.data

/**
 * Parse Json data from url
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 10: Parsing data
 * 當我們使用Gson來解析json到類別中時，屬性的名字必須要與json中的名字一樣，或者可以指定一個serialised name（序列化名稱）。
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */

data class ForecastResult(val city: City, val list: List<Forecast>)

data class City(val id: Long, val name: String, val coord: Coordinates, val country: String, val population: Int)

data class Coordinates(val lon: Float, val lat: Float)

data class Forecast(val dt: Long, val temp: Temperture, val pressure: Float, val humidity: Int,
                    val weather: List<Weather>, val speed: Float, val deg: Int, val clouds: Int, val rain: Float)

data class Temperture(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)

data class Weather(val id: Long, val main: String, val description: String, val icon: String)
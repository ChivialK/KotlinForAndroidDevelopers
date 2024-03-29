package com.hcchiang.kotlinforandroiddevelopers.domain.commands

import com.hcchiang.kotlinforandroiddevelopers.data.server.ForecastRequest
import com.hcchiang.kotlinforandroiddevelopers.domain.mappers.ForecastDataMapper
import com.hcchiang.kotlinforandroiddevelopers.domain.model.ForecastList

/**
 * Request Forecast data
 * @author H.C.CHIANG
 * @version 0.1
 * @link Command
 *
 * Chapter 10: Parsing data
 * Chapter 19: Saving and requesting data from database
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
class RequestForecastCommand(private val zipCode: Long) : Command<ForecastList> {

    /*
     * 1. Request Forecast from Url and parse json by data class
     * 2. convert data to ForecastList
     * 3. return back to MainActivity
     */
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}
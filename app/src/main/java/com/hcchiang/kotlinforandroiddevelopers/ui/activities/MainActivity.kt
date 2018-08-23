package com.hcchiang.kotlinforandroiddevelopers.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.hcchiang.kotlinforandroiddevelopers.R
import com.hcchiang.kotlinforandroiddevelopers.domain.commands.RequestForecastCommand
import com.hcchiang.kotlinforandroiddevelopers.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/**
 *  Chapter 12: Making the forecast list clickable
 *  Chapter 13: Lambdas
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        // Chapter 12: Making the forecast list clickable
        /*doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecast_list.adapter = ForecastListAdapter(result,
                        object : ForecastListAdapter.OnItemClickListener {
                            override fun invoke(forecast: Forecast) {
                                toast(forecast.date)
                            }
                        })
            }
        }*/

        // Chapter 13: Lambdas
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                val adapter = ForecastListAdapter(result) { toast(it.date) }
                forecastList.adapter = adapter
            }
        }
    }
}

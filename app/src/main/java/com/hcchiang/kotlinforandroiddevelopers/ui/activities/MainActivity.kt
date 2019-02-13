package com.hcchiang.kotlinforandroiddevelopers.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.hcchiang.kotlinforandroiddevelopers.R
import com.hcchiang.kotlinforandroiddevelopers.domain.commands.RequestForecastCommand
import com.hcchiang.kotlinforandroiddevelopers.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/**
 *  Chapter 12: Making the forecast list clickable
 *  Chapter 13: Lambdas
 *  Chapter 15: Kotlin Android Extensions
 *  Chapter 19: Saving and requesting data from database
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand(94043).execute()
            uiThread {
                val adapter = ForecastListAdapter(result, { toast(it.description) })
                forecastList.adapter = adapter
            }
        }
    }
}

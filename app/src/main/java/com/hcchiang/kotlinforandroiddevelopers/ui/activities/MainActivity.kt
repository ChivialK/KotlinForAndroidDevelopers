package com.hcchiang.kotlinforandroiddevelopers.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.hcchiang.kotlinforandroiddevelopers.R
import com.hcchiang.kotlinforandroiddevelopers.domain.commands.RequestForecastCommand
import com.hcchiang.kotlinforandroiddevelopers.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 *  Chapter 5: Writing your first class
 *  Chapter 10: Parsing data
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecast_list.layoutManager = LinearLayoutManager(this)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecast_list.adapter = ForecastListAdapter(result)
            }
        }
    }
}

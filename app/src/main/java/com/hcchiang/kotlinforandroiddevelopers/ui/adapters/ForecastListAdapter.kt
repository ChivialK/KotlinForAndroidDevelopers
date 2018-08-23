package com.hcchiang.kotlinforandroiddevelopers.ui.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.hcchiang.kotlinforandroiddevelopers.domain.model.ForecastList

/**
 * Basic List Adapter
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 5: Writing your first class
 * Chapter 10: Parsing data
 * Chapter 11: Operator overloading
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
class ForecastListAdapter(private val weekForecast: ForecastList)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(TextView(parent.context))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Chapter 10: Parsing data
        /*with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }*/

        // Chapter 11: Operator overloading
        with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    // Chapter 10: Parsing data
    //override fun getItemCount(): Int = weekForecast.dailyForecast.size

    // Chapter 11: Operator overloading
    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
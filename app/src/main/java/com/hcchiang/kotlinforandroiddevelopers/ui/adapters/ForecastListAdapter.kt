package com.hcchiang.kotlinforandroiddevelopers.ui.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.hcchiang.kotlinforandroiddevelopers.R
import com.hcchiang.kotlinforandroiddevelopers.domain.model.Forecast
import com.hcchiang.kotlinforandroiddevelopers.domain.model.ForecastList
import com.hcchiang.kotlinforandroiddevelopers.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Basic List Adapter
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 11: Operator overloading
 * Chapter 12: Making the forecast list clickable
 * Chapter 13: Lambdas
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemClick: (Forecast) -> Unit)    // Chapter 13: Lambdas
                          //private val itemClick: ForecastListAdapter.OnItemClickListener)     // Chapter 12: Making the forecast list clickable
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    // Chapter 13: Lambdas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    // Chapter 12: Making the forecast list clickable
    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return RecyclerView.ViewHolder(view, itemClick)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }*/

    override fun getItemCount(): Int = weekForecast.size

    // Chapter 12: Making the forecast list clickable
    /*class ViewHolder(view: View, private val itemClick: AdapterView.OnItemClickListener)
            : RecyclerView.ViewHolder(view) {*/

    // Chapter 13: Lambdas
    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit)
        : RecyclerView.ViewHolder(view) {

        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high}º"
                minTemperatureView.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}
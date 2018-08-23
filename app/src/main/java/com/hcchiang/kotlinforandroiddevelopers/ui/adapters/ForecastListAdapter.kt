package com.hcchiang.kotlinforandroiddevelopers.ui.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Basic List Adapter
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 5: Writing your first class
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
class ForecastListAdapter(private val items: List<String>)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(TextView(parent.context))

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
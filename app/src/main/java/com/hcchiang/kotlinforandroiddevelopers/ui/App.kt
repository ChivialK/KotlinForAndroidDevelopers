package com.hcchiang.kotlinforandroiddevelopers.ui

import android.app.Application
import com.hcchiang.kotlinforandroiddevelopers.ui.utils.DelegatesExt

/**
 * Application Singleton
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 16: Application Singleton and Delegated Properties
 *
 * Created on 2018/8/29. Copyright © 2017 All rights reserved
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
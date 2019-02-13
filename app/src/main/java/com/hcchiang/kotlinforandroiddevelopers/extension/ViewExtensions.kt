package com.hcchiang.kotlinforandroiddevelopers.extension

import android.content.Context
import android.view.View

/**
 * Anko API - add new extension to View
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Created on 2018/8/23. Copyright © 2017 All rights reserved
 */
val View.ctx: Context
    get() = context
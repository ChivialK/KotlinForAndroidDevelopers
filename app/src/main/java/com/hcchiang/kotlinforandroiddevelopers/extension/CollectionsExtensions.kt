package com.hcchiang.kotlinforandroiddevelopers.extension

/**
 *
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 19: Saving and requesting data from database
 *
 * Created on 2018/8/29. Copyright © 2017 All rights reserved
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()
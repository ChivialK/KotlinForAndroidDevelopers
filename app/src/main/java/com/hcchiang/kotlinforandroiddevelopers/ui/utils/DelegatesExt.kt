package com.hcchiang.kotlinforandroiddevelopers.ui.utils

import kotlin.reflect.KProperty

/**
 * Delegated Properties
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 16: Application Singleton and Delegated Properties
 *
 * Created on 2018/8/29. Copyright © 2017 All rights reserved
 */
object DelegatesExt {
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}

class NotNullSingleValueVar<T> {

    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
            value ?: throw IllegalStateException("${property.name} not initialized")

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }
}

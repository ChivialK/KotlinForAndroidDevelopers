package com.hcchiang.kotlinforandroiddevelopers.domain.commands

/**
 * Generic class
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 10: Parsing data
 *
 * Created on 2018/8/22. Copyright © 2017 All rights reserved
 */
interface Command<out T> {
    fun execute(): T
}
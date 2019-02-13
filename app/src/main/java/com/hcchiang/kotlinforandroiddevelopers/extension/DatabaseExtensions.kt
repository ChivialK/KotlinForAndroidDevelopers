package com.hcchiang.kotlinforandroiddevelopers.extension

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * Create extension to solve override conflict between two functions
 * @author H.C.CHIANG
 * @version 0.1
 *
 * Chapter 19: Saving and requesting data from database
 *
 * Created on 2018/8/29. Copyright © 2017 All rights reserved
 */
fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> =
        parseList(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })

fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? =
        parseOpt(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })

fun SQLiteDatabase.clear(tableName: String) {
    execSQL("delete from $tableName")
}
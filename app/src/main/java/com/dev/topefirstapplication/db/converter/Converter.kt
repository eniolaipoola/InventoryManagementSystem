package com.dev.topefirstapplication.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * Copyright (c) 2020 Eniola Ipoola
 * All rights reserved
 * Created on 03-Feb-2020
 */
class Converter {
    @TypeConverter
    fun fromListToInteger(integerList: List<Int?>?): String? {
        if (integerList == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Int?>?>() {}.type
        return gson.toJson(integerList, type)
    }

    @TypeConverter
    fun toIntegerList(integerListString: String?): List<Int>? {
        if (integerListString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Int?>?>() {}.type
        return gson.fromJson(integerListString, type)
    }

    companion object {
        @TypeConverter
        fun toDate(timestamp: Long?): Date? {
            return if (timestamp == null) null else Date(timestamp)
        }

        @TypeConverter
        fun toTimestamp(date: Date?): Long? {
            return date?.time
        }
    }
}
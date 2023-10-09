package com.example.authmobileappintern2grow.ui

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class AppPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "MyAppPrefs",
        Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun <T> putObject(key: String, obj: T) {
        val json = gson.toJson(obj)
        sharedPreferences.edit().putString(key, json).apply()
    }

    fun <T> getObject(key: String, clazz: Class<T>): T {
        val json = sharedPreferences.getString(key, null)
        return gson.fromJson(json, clazz)
    }

    fun removeObject(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

}

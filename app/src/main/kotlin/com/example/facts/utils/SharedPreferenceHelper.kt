package com.example.facts.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceHelper {
    private lateinit var pref: SharedPreferences
    private const val pref_name = "PREF"
    private const val titleKey = "TITLE"

    fun initPreference(context: Context) {
        pref = context.getSharedPreferences(pref_name, Context.MODE_PRIVATE)
    }

    fun saveTitle(title: String) {
        val prefsEditor: SharedPreferences.Editor = pref.edit()
        prefsEditor.apply() {
            putString(titleKey, title)
            apply()
        }
    }

    fun getTitle(): String? {
        return pref.getString(titleKey, "Testing")
    }
}
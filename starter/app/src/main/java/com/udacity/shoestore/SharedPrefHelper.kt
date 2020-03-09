package com.udacity.shoestore

import android.content.Context
import android.content.SharedPreferences

object SharedPrefHelper {

    private var PRIVATE_MODE = 0
    private val PREF_NAME = "shoe_pref"
    private lateinit var sharedPref:SharedPreferences
    private const val IS_LOGGED_IN_PREF = "is_logged_in"

    fun init(context: Context ) {
        sharedPref  =  context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)

    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var loggedIn: Boolean
        get() = sharedPref.getBoolean(IS_LOGGED_IN_PREF, false)

        set(value) = sharedPref.edit {
            it.putBoolean(IS_LOGGED_IN_PREF, value)
        }

}
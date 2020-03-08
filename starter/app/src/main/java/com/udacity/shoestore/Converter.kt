package com.udacity.shoestore

import androidx.databinding.InverseMethod
object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(
        value: Double
    ): String {
        return value.toString()
    }

    @JvmStatic fun stringToDouble(
        value: String
    ): Double {
        if (value.isNotEmpty())
        return value.toDouble()
        else return 0.0
    }
}
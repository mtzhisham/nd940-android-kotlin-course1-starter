package com.udacity.shoestore

import android.app.Application

class ShoeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPrefHelper.init(this)

    }

}
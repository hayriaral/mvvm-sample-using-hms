package com.aral.mvvm_sample_using_hms

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        lateinit var INSTANCE: App

        var context: Context? = null
            private set
    }

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        context = applicationContext
    }
}
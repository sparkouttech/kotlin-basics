package com.example.kotlin.ui.app

import android.app.Application
import com.example.kotlin.BuildConfig
import com.example.kotlin.ui.ReleaseTree
import timber.log.Timber
import timber.log.Timber.DebugTree


class AppModule : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }

    }
}
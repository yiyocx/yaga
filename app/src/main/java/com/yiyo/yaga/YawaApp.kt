package com.yiyo.yaga

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import yiyo.com.core.di.networkModule
import yiyo.com.dashboard.di.dashBoardModule

class YawaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@YawaApp)
            modules(listOf(networkModule, dashBoardModule))
        }
    }
}
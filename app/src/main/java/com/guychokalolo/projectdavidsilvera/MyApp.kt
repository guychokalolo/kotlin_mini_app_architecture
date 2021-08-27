package com.guychokalolo.projectdavidsilvera

import android.app.Application
import com.guychokalolo.projectdavidsilvera.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(appModules)
        }
    }
}
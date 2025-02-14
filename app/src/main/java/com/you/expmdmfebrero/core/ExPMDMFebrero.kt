package com.you.expmdmfebrero.core

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module

class ExPMDMFebrero : Application() {
    /*
    override fun onCreate() {

        super.onCreate()
        startKoin {
            androidContext(this@ExPMDMFebrero)
            //modules(AppModule().module)
        }
    }
    */
}
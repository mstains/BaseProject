package com.moran.base.activity

import android.app.Application
import okhttp3.OkHttpClient

open abstract class BaseModuleApplication : Application() {



    override fun onCreate() {
        super.onCreate()
        init()
    }


    protected abstract fun init()
}
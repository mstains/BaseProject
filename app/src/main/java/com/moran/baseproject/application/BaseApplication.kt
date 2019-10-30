package com.moran.baseproject.application

import androidx.multidex.MultiDex
import com.moran.base.activity.BaseModuleApplication

class BaseApplication : BaseModuleApplication() {


    override fun init() {
        MultiDex.install(this)

    }
}
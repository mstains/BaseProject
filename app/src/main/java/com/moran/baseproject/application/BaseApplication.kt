package com.moran.baseproject.application

import androidx.multidex.MultiDex
import com.moran.base.activity.BaseModuleApplication
import com.moran.base.utils.LogUtils
import java.io.File


class BaseApplication : BaseModuleApplication() {


    override fun init() {

        MultiDex.install(this)


    }
}
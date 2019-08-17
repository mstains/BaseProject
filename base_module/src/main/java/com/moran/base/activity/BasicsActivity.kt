package com.moran.base.activity

import android.os.Bundle

abstract class BasicsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }


}
package com.moran.baseproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.moran.base.activity.BaseActivity

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}

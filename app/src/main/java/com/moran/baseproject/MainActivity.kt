package com.moran.baseproject

import com.moran.base.activity.CommActivity

class MainActivity : CommActivity<MainPresenter>(),MainView {
    override fun getInfo() {

    }

    override fun createrPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}

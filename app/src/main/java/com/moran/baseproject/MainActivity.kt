package com.moran.baseproject

import android.widget.Toast
import com.moran.base.activity.CommActivity

class MainActivity : CommActivity<MainPresenter>(),MainView {


    override fun initView() {

    }

    override fun initData() {
        presenter.getInfo()
    }

    override fun getInfo() {

        Toast.makeText(this,"nice",Toast.LENGTH_LONG).show()
    }

    override fun createrPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}

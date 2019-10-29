package com.moran.baseproject

import android.widget.Toast
import com.moran.base.activity.CommActivity
import com.moran.base.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CommActivity<MainPresenter>(),MainView {


    override fun initView() {



        web_View.loadUrl("https://www.baidu.com/")

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

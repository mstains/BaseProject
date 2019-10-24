package com.moran.baseproject

import android.widget.Toast
import com.moran.base.activity.CommActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CommActivity<MainPresenter>(),MainView {


    override fun initView() {

        dialog_button.setOnClickListener {

            MainDialogFragment.get().show(supportFragmentManager,"TAG")


        }

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

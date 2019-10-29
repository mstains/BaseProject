package com.moran.baseproject

import android.content.DialogInterface
import android.widget.Toast
import com.moran.base.activity.CommActivity
import com.moran.base.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CommActivity<MainPresenter>(), MainView {


    override fun initView() {


        dialog_bt.setOnClickListener {

            val loadDialog = LoadDialog(this)

            loadDialog.cancel_btnClickListener = object : DialogInterface.OnClickListener {

                override fun onClick(p0: DialogInterface?, p1: Int) {
                    p0!!.dismiss()

                }
            }

            loadDialog.confirm_btnClickListener = object : DialogInterface.OnClickListener {

                override fun onClick(p0: DialogInterface?, p1: Int) {

                    p0!!.dismiss()

                }
            }

            loadDialog.showDialog()

        }


//        web_View.loadUrl("https://www.baidu.com/")

    }

    override fun getInfo() {

        Toast.makeText(this, "nice", Toast.LENGTH_LONG).show()
    }

    override fun createrPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}

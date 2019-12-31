package com.moran.baseproject.common.dialog

import android.content.Context
import android.widget.TextView
import com.moran.base.dialog.BaseDialog
import com.moran.baseproject.R

class FingerPrintDialog(context: Context) : BaseDialog(context) {

    private var tv_user_account : TextView? = null

    private var tv_cancel : TextView? = null


    override fun getLayoutId(): Int {

        return R.layout.dialog_fingerprint_layout

    }

    override fun initView() {

        tv_user_account = findViewById(R.id.tv_user_account)
        tv_cancel = findViewById(R.id.tv_cancel)

    }

    override fun initData() {


        val buffer = StringBuffer()

        buffer.append("账号：")

        buffer.append("xxxxxxxxx")



        tv_user_account!!.text = buffer.toString()


        tv_cancel!!.setOnClickListener {

            onDismiss()

        }





    }

    override fun isCancel(): Boolean {

        return false

    }
}
package com.moran.baseproject

import android.content.Context
import android.content.DialogInterface
import android.widget.TextView
import com.moran.base.dialog.BaseDialog

class LoadDialog : BaseDialog {


    private var cancel_btn: TextView? = null

    private var confirm_btn: TextView? = null

    override fun getLayoutId(): Int {

        return R.layout.main_ad_dialog_layout

    }

    override fun initView() {

        cancel_btn = findViewById(R.id.cancel_btn)


        cancel_btn!!.setOnClickListener {

            if (cancel_btnClickListener != null){

                cancel_btnClickListener!!.onClick(dialog, DialogInterface.BUTTON_NEGATIVE)
            }

        }

        confirm_btn = findViewById(R.id.confirm_btn)


        confirm_btn!!.setOnClickListener {

            if (confirm_btnClickListener != null){

                confirm_btnClickListener!!.onClick(dialog,DialogInterface.BUTTON_POSITIVE)
            }

        }

    }

    override fun initData() {


    }

    override fun isCancel(): Boolean {


        return false

    }


    constructor(context: Context) : super(context) {

    }
}
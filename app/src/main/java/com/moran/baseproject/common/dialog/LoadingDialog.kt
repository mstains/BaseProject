package com.moran.baseproject.common.dialog

import android.content.Context
import com.moran.base.dialog.BaseDialog
import com.moran.baseproject.R

class LoadingDialog(context: Context) : BaseDialog(context) {


    override fun getLayoutId(): Int {

        return R.layout.dialog_load_layout
    }

    override fun initView() {

    }

    override fun initData() {



    }

    override fun isCancel(): Boolean {

        return true
    }
}
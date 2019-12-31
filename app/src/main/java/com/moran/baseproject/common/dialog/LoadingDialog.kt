package com.moran.baseproject.common.dialog

import android.content.Context
import com.airbnb.lottie.LottieAnimationView
import com.moran.base.dialog.BaseDialog
import com.moran.baseproject.R

class LoadingDialog(context: Context) : BaseDialog(context) {

    private var lottieAnimationView : LottieAnimationView? = null

    override fun getLayoutId(): Int {

        return R.layout.dialog_load_layout
    }

    override fun initView() {
        lottieAnimationView = findViewById(R.id.lottieAnimationView)

    }

    override fun initData() {

        lottieAnimationView?.playAnimation()


    }

    override fun isCancel(): Boolean {

        return true
    }
}
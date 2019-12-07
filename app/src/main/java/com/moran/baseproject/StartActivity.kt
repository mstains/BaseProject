package com.moran.baseproject

import com.moran.base.activity.BasicsActivity
import com.moran.baseproject.common.FingerPrintDialog
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BasicsActivity() {
    override fun getLayoutId(): Int {

        return R.layout.activity_start
    }


    override fun initData() {

        fingerprint_login.setOnClickListener {

            val fingerPrintDialog = FingerPrintDialog(this@StartActivity)

            fingerPrintDialog.createDialog()

            fingerPrintDialog.showDialog()


        }
    }
}

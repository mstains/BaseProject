package com.moran.baseproject

import com.moran.base.dialog.BaseDialogfragment

class MainDialogFragment : BaseDialogfragment() {


    companion object{

        private var instance : MainDialogFragment? = null

        get(){

            if (field == null){

                field = MainDialogFragment()
            }

            return field

        }

        @Synchronized
        fun get(): MainDialogFragment{

            return instance!!
        }


    }



    override fun getLayoutId(): Int {

        return R.layout.main_ad_dialog_layout
    }

    override fun initView() {
    }

    override fun initData() {

        setAlpha(1f)

        setDimAmount(0.5f)

    }




    override fun isCancel(): Boolean {

        return true
    }


}
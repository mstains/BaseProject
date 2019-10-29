package com.moran.base.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

class Utils {


    companion object {

        private var instance: Utils? = null
        fun getInstance() : Utils{

            if (instance == null) {
                synchronized(Utils::class){

                    instance = Utils()

                }
            }
            return instance!!
        }

    }


    fun getScreenWidth(context: Context): Int {

        val dm = DisplayMetrics()

        val vm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        vm.defaultDisplay.getMetrics(dm)


        return dm.widthPixels

    }
}
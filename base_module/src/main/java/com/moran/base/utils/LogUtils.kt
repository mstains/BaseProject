package com.moran.base.utils

import android.util.Log
import com.moran.base.BuildConfig

class LogUtils {
    companion object {
        private val RELEASE = BuildConfig.DEBUG

        private val TAG = "TAG"

        fun e(msg: Any){

            if (RELEASE){
                Log.e(TAG,msg.toString())
            }
        }

        fun e(tag : String,msg : Any){

            if (RELEASE){
                Log.e(tag,msg.toString())

            }
        }



        fun d(msg: Any){
            if (RELEASE){
                Log.d(TAG,msg.toString())
            }
        }

        fun d(tag : String,msg : Any){

            if (RELEASE){
                Log.d(tag,msg.toString())

            }
        }




        fun w(msg: Any){
            if (RELEASE){
                Log.w(TAG,msg.toString())
            }
        }

        fun w(tag : String,msg : Any){

            if (RELEASE){
                Log.w(tag,msg.toString())

            }
        }





        fun v(msg: Any){
            if (RELEASE){
                Log.v(TAG,msg.toString())
            }
        }

        fun v(tag : String,msg : Any){

            if (RELEASE){
                Log.v(tag,msg.toString())

            }
        }



        fun i(msg: Any){
            if (RELEASE){
                Log.i(TAG,msg.toString())
            }
        }

        fun i(tag : String,msg : Any){

            if (RELEASE){
                Log.i(tag,msg.toString())
            }
        }

    }

}
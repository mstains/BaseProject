package com.moran.base.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager


/**
  * @Package:
  * @ClassName:
  * @Description:    工具类
  * @Author:         moran
  * @CreateDate:     2019-11-04 20:42
  * @UpdateUser:     更新者：moran
  * @UpdateDate:     2019-11-04 20:42
  * @UpdateRemark:   更新说明：
  * @Version:        1.0
 */
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


     /**
      * 获取屏幕宽度
      * @method
      * @date: 2019-11-03 20:46
      * @author: moran
      * @param context 上下文对象
      * @return 屏幕宽度
      */
    fun getScreenWidth(context: Context): Int {

        val dm = DisplayMetrics()

        val vm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        vm.defaultDisplay.getMetrics(dm)

        return dm.widthPixels

    }


    /**
     * 获取屏幕宽度
     * @method
     * @date: 2019-11-03 20:46
     * @author: moran
     * @param context 上下文对象
     * @return 屏幕宽度
     */
    fun getScreenHeight(context: Context): Int {

        val dm = DisplayMetrics()

        val vm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

        vm.defaultDisplay.getMetrics(dm)

        return dm.heightPixels

    }



     /**
      * 获取系统状态栏高度
      * @method
      * @date: 2019-11-03 20:46
      * @author: moran
      * @param context 上下文对象
      * @return 系统状态栏高度
      */
    fun getStateBarHeight(context: Context) : Int{

        var result = 0

        var resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")

        if (resourceId > 0){
            result = context.resources.getDimensionPixelSize(resourceId)
        }

        return  result

    }
}
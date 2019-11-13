package com.moran.base.activity

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.*
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.ColorUtils
import com.moran.base.R
import com.moran.base.utils.LogUtils
import com.moran.base.utils.Utils
import com.moran.base.view.CustomLinearLayout
import com.walkud.rom.checker.Rom
import com.walkud.rom.checker.RomIdentifier


abstract class BaseActivity : AppCompatActivity(), CustomLinearLayout.BaseModuleClickListener {


    companion object {

        private val FAKE_STATUS_BAR_VIEW_ID = R.id.statusbarutil_fake_status_bar_view

        private val FAKE_TRANSLUCENT_VIEW_ID = R.id.statusbarutil_translucent_view
    }


    override fun onFinish() {

        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val rootView = LayoutInflater.from(this).inflate(getLayoutId(), null) as LinearLayout

        if (rootView is CustomLinearLayout) {
            rootView.clickListener = this
        }
        setContentView(rootView)
        //initStatusBar()
        initView()
        initData()
    }



//    private fun initStatusBar(){
//        window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_STABLE
//        window.statusBarColor = statusBarColor()
//    }








    //导航栏默认颜色
    open fun statusBarColor(): Int {

        return resources.getColor(R.color.colorRed)
    }

    open fun statusBarAlpha(): Int {

        return 0
    }

     open fun isTranslucent(): Boolean {

        return false
    }


    /**
     * 计算状态栏颜色
     *
     * @param color color值
     * @param alpha alpha值
     * @return 最终的状态栏颜色
     */
    private fun calculateStatusColor(color: Int, alpha: Int): Int {

        if (alpha == 0) {

            return color
        }

        val a = 1 - alpha / 255

        var red = color shr 16 and 0xff
        var green = color shr 8 and 0xff
        var blue = color and 0xff
        red = (red * a + 0.5).toInt()
        green = (green * a + 0.5).toInt()
        blue = (blue * a + 0.5).toInt()
        return 0xff shl 24 or (red shl 16) or (green shl 8) or blue


    }



     /**
      * 颜色是否高亮
      * @method
      * @date: 2019-11-08 13:22
      * @author: moran
      * @param
      * @return
      */
    private fun isLightColor (@ColorInt color : Int) : Boolean{

        return ColorUtils.calculateLuminance(color) >= 0.5
    }

    protected open fun initView() {

    }

    protected open fun initData() {

    }

    protected abstract fun getLayoutId(): Int



}
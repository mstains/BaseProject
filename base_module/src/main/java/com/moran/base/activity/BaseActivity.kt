package com.moran.base.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.moran.base.view.CustomLinearLayout


abstract class BaseActivity : AppCompatActivity(), CustomLinearLayout.BaseModuleClickListener {

    override fun onFinish() {
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootView: View = LayoutInflater.from(this).inflate(getLayoutId(),null)
        setContentView(rootView)
        if (rootView is CustomLinearLayout){
            rootView.clickListener = this
        }
        initStatus()
        initView()

        initData()

    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
    }


     private fun initStatus(){

         //系统版本大于等于21
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
             val window = window
             window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
             window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
             window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
             window.statusBarColor = Color.TRANSPARENT
         }

         else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){

             var localLayoutParams = window.attributes
             localLayoutParams.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or localLayoutParams.flags
         }



     }




    protected open fun initView(){

    }

    protected open fun initData(){

    }

    protected abstract fun getLayoutId():Int
}
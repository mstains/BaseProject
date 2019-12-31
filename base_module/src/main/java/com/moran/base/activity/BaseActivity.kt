package com.moran.base.activity

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.moran.base.R
import com.moran.base.utils.StatusBarUtil
import com.moran.base.view.CustomLinearLayout


abstract class BaseActivity : AppCompatActivity(), CustomLinearLayout.onFinishClickListener {



    override fun onFinish() {
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootView = LayoutInflater.from(this).inflate(getLayoutId(), null)

        if (rootView is CustomLinearLayout) {
            rootView.clickListener = this
        }
        setContentView(rootView)
        setStatusBar()
        initView()
        initData()
    }









    protected open fun initView() {

    }

    protected open fun initData() {

    }

    protected abstract fun getLayoutId(): Int


    fun baseStartActivity(clazz:Class<*>){

        var intent = Intent()

        intent.setClass(this,clazz)

        startActivity(intent)
    }

    fun baseStartActivity(clazz: Class<*>, parcelable : Parcelable){

        var intent  = Intent()
        intent.setClass(this,clazz)
        intent.putExtra(ActivityConfig.defaultParcelable,parcelable)
        startActivity(intent)
    }


    fun baseStartActivity(clazz: Class<*>, bundle : Bundle){

        var  intent = Intent()

        intent.setClass(this,clazz)

        intent.putExtra(ActivityConfig.defaultBundle,bundle)
        startActivity(intent)
    }


    open fun setStatusBar(){

        StatusBarUtil.setStatusColor(this, resources.getColor(R.color.colorBuild), 0)
    }


}
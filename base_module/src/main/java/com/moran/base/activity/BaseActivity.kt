package com.moran.base.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
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
        initView()
    }






    protected open fun initView(){

    }

    protected open fun initData(){

    }

    protected abstract fun getLayoutId():Int
}
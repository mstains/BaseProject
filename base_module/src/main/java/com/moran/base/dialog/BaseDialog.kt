package com.moran.base.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.moran.base.R

abstract class BaseDialog : Dialog {



    private var inflater : LayoutInflater

    private var rootView : View


    constructor(context: Context) : super(context, R.style.mystyle)

    init {

        inflater = LayoutInflater.from(context)

        rootView = inflater.inflate(getLayoutId(),null)

    }



    //布局id
    protected abstract fun getLayoutId(): Int

    //初始化控件
    protected abstract fun initView()

    //初始化数据
    protected abstract fun initData()

    //点击外部是否可关闭
    protected abstract fun isCancel(): Boolean






}
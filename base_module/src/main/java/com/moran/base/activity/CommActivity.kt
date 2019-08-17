package com.moran.base.activity

import android.os.Bundle
import com.moran.base.presenter.BasePresenter
import com.moran.base.presenter.BaseView

abstract class CommActivity <P : BasePresenter<BaseView>>: BaseActivity(),BaseView {



    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createrPresenter()
        initData()
    }


    protected abstract fun createrPresenter():P





}
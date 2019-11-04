package com.moran.base.activity

import android.os.Bundle
import com.moran.base.presenter.BasePresenter
import com.moran.base.presenter.BaseView

abstract class CommActivity <P : BasePresenter<BaseView>>: BaseActivity(),BaseView {



    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createrPresenter()
    }


    protected abstract fun createrPresenter():P


    override fun onShowLoading() {

    }

    override fun onDismissLoad() {

    }

    override fun onError(errorMsg: String) {

    }


}
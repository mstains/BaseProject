package com.moran.base.activity.presenter

interface BaseView {

    fun onShowLoading()

    fun onDismissLoad()

    fun onError(errorMsg:String)

}
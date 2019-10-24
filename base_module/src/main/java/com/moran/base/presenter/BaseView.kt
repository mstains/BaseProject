package com.moran.base.presenter

interface BaseView {

    fun onShowLoading()

    fun onDismissLoad()

    fun onError(errorMsg:String)

}
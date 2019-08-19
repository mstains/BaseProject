package com.moran.baseproject

import com.moran.base.http.ApiRetrofit
import com.moran.base.presenter.BasePresenter

class MainPresenter constructor(baseView: MainView) : BasePresenter<MainView>(baseView) {


    fun getInfo(){
        ApiRetrofit.get()
        baseView.getInfo()
    }


}
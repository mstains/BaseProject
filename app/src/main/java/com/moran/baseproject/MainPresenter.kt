package com.moran.baseproject

import android.util.Log
import com.moran.base.http.BaseObserver
import com.moran.base.presenter.BasePresenter

class MainPresenter constructor(baseView: MainView) : BasePresenter<MainView>(baseView) {


    fun getInfo(){

       getExecute ("https://www.oschina.net/",object : BaseObserver<String>(){
            override fun onSuccess(t: String) {
                Log.e("ssss",t)
            }
        })
    }


}
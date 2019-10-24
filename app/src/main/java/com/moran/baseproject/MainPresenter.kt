package com.moran.baseproject

import android.util.Log
import com.moran.base.http.callback.BaseCallback
import com.moran.base.http.callback.JsonCallBack
import com.moran.base.presenter.BasePresenter

class MainPresenter constructor(baseView: MainView) : BasePresenter<MainView>(baseView) {


    fun getInfo(){

        val url = "https://testapp.zjfae.com/ife/azj/pbupg.do?fh=VUPGAZJ000000J00"

        val map = HashMap<String,String>()
        map.set("platform", "1")
        map.set("versionid", "1.6.48")

        postExecute(url,map,AppUpDate::class.java,object : JsonCallBack<AppUpDate>(baseView){

            override fun onSuccess(t: AppUpDate) {

            }
        })
    }


}
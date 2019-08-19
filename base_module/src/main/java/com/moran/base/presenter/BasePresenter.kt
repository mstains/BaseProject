package com.moran.base.presenter

import com.moran.base.http.ApiRetrofit
import com.moran.base.http.ApiServer
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver


open class BasePresenter<out V : BaseView>(val baseView: V) {

    private var compositeDisposable : CompositeDisposable? = null

    private val apiServer: ApiServer
    init {
        apiServer = ApiRetrofit.get().apiServer
    }




    fun getExecute( override: Observable<*>,observer : DisposableObserver<*>){


    }





}
package com.moran.base.presenter

import com.moran.base.http.ApiRetrofit
import com.moran.base.http.ApiServer
import com.moran.base.http.BaseObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.util.NotificationLite.disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody


open class BasePresenter<out V : BaseView>(val baseView: V) {

    private var compositeDisposable : CompositeDisposable? = null

    private val apiServer: ApiServer
    init {
        apiServer = ApiRetrofit.get().apiServer
    }


    fun <T : Any> getExecute(url:String,disposable: BaseObserver<T>){
        if (compositeDisposable == null){
            compositeDisposable = CompositeDisposable()
        }

        compositeDisposable!!.add(apiServer.getExecute<T>(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposable))

//        compositeDisposable!!.add(apiServer.getExecute(url).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
    }



}





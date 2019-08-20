package com.moran.base.http.callback

import com.moran.base.presenter.BaseView

abstract class BaseCallback<T> constructor(val baseView: BaseView) {

    fun onStart() {
        baseView.onShowLoading()
    }

    fun onError( errorMsg : String){
        baseView.onError(errorMsg)
    }

    abstract fun onSuccess(t: T)

    fun onComplete(){
        baseView.onDismissLoad()
    }


}
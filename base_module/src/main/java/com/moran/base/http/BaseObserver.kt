package com.moran.base.http

import io.reactivex.observers.DisposableObserver

abstract class BaseObserver<T> : DisposableObserver<T>() {

    override fun onStart() {
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
    }

    override fun onComplete() {
    }

    abstract fun onSuccess(t: T)
}
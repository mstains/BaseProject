package com.moran.base.http

abstract class BaseObserver<T> {


    abstract fun onSuccess(t: T)
}
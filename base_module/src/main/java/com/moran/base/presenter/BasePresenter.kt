package com.moran.base.presenter


class BasePresenter<V : BaseView> {

    protected lateinit var baseView: V



    constructor(baseView: V){
        this.baseView = baseView
    }








}
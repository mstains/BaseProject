package com.moran.base.adapter

interface ItemClickListener<T> {


    /**
     * item点击事件
     * @param t 泛型
     * @param position 下标
     * */
    fun onItemClickListener(t:T,position:Int)
}
package com.moran.baseproject.common.fragment

import com.moran.base.fragment.BaseFragment
import com.moran.base.utils.StatusBarUtil
import com.moran.baseproject.R

class ListFragment : BaseFragment(){

    override fun initData() {
    }

    override fun initView() {

    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_list_layout

    }


    override fun setStatusBar() {

        StatusBarUtil.setColor(getActivity(),resources.getColor(R.color.colorGreen),0)
    }



}
package com.moran.baseproject.common.fragment

import androidx.room.Room
import com.moran.base.fragment.BaseFragment
import com.moran.base.utils.StatusBarUtil
import com.moran.baseproject.R
import com.moran.baseproject.data.AppDatabase

class HomeFragment : BaseFragment() {



    override fun initData() {

        val db = Room.databaseBuilder<AppDatabase>(context!!,AppDatabase::class.java,"").build()

    }


    override fun initView() {


    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_home_layout

    }


    override fun setStatusBar() {

        StatusBarUtil.setColor(getActivity(),resources.getColor(R.color.colorOrange),0)
    }





}
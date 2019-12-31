package com.moran.baseproject.common.fragment

import android.widget.ImageView
import com.moran.base.fragment.BaseFragment
import com.moran.base.utils.StatusBarUtil
import com.moran.baseproject.R

class MoreFragment : BaseFragment() {



    private var banner : ImageView? = null

    override fun initData() {

        //Glide.with(this).load(R.mipmap.banner).into(banner!!)
    }

    override fun initView() {

        banner = findViewById(R.id.banner)




    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_more_layout
    }


    override fun setStatusBar() {

        StatusBarUtil.setColor(getActivity(),resources.getColor(R.color.colorRed),0)
    }
}
package com.moran.baseproject.fragment

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.moran.base.fragment.BaseFragment
import com.moran.base.utils.imageLoad.ImageLoad
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



    override fun isImageBanner(): Boolean {

        return true
    }
}
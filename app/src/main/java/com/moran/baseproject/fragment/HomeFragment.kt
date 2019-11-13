package com.moran.baseproject.fragment

import android.content.Intent
import android.widget.TextView
import com.moran.base.fragment.BaseFragment
import com.moran.baseproject.R
import com.moran.baseproject.activity.login.RegisterActivity

class HomeFragment : BaseFragment() {



    private var jump : TextView? = null

    override fun initData() {

        jump!!.setOnClickListener{

          val intent = Intent(mContext,RegisterActivity::class.java)

            startActivity(intent)

        }
    }







    override fun initView() {

        jump = findViewById(R.id.jump);
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_home_layout

    }



}
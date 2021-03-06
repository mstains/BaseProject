package com.moran.baseproject.common.activity

import android.view.View
import com.moran.base.activity.BasicsActivity
import com.moran.base.utils.StatusBarUtil
import com.moran.baseproject.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BasicsActivity(), View.OnClickListener {
    override fun getLayoutId(): Int {


        return R.layout.activity_start


    }

    override fun initView() {

        tv_leapfrog.setOnClickListener(this)
    }

    override fun initData() {

    }


    override fun setStatusBar() {

        StatusBarUtil.setTranslucentForImageView(this, 0, tv_leapfrog)
    }


    override fun onClick(p0: View?) {

        when (p0?.id) {

            R.id.tv_leapfrog -> {

                baseStartActivity(HomeActivity::class.java)

                finish()

            }


        }

    }

}

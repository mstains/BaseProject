package com.moran.baseproject.common.activity.login

import com.moran.base.activity.CommActivity
import com.moran.baseproject.R
import com.moran.baseproject.common.activity.login.presenter.LoginPresenter
import com.moran.baseproject.common.activity.login.presenter.LoginView

class LoginActivity : CommActivity<LoginPresenter>(),LoginView {
    override fun createrPresenter(): LoginPresenter {

        return LoginPresenter(this)
    }

    override fun getLayoutId(): Int {

        return R.layout.activity_login
    }


}

package com.moran.baseproject.activity.login

import com.moran.base.activity.CommActivity
import com.moran.baseproject.R
import com.moran.baseproject.activity.login.presenter.LoginPresenter
import com.moran.baseproject.activity.login.presenter.LoginView

class LoginActivity : CommActivity<LoginPresenter>(),LoginView {
    override fun createrPresenter(): LoginPresenter {

        return LoginPresenter(this)
    }

    override fun getLayoutId(): Int {

        return R.layout.activity_login
    }


}

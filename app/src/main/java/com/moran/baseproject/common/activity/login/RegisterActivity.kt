package com.moran.baseproject.common.activity.login

import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import com.moran.base.activity.BasicsActivity
import com.moran.baseproject.R
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : BasicsActivity(), View.OnClickListener {


    override fun onClick(view: View?) {

        when (view!!.id) {

            //发送短信验证码
            R.id.tv_sendSmsCode -> {

                if (!TextUtils.isEmpty(ed_phoneNumber.text.toString())) {


                } else {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_LONG).show()
                }

            }


            //查看密码
            R.id.ck_passWord_state -> {

                if (ck_passWord_state.isChecked) {
                    ed_passWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                } else {
                    ed_passWord.setTransformationMethod(PasswordTransformationMethod.getInstance())
                }


            }


            //查看密码
            R.id.ck_confirm_passWord_state -> {

                if (ck_confirm_passWord_state.isChecked) {
                    ed_confirmPassWord.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                } else {
                    ed_confirmPassWord.setTransformationMethod(PasswordTransformationMethod.getInstance())
                }

            }


            //选择开户协议
            R.id.select_agreement_layout -> {

                read_agreement.isChecked = read_agreement.isChecked


            }

            //打开开户协议
            R.id.tv_open_agreement -> {

                Toast.makeText(this, "打开开户协议", Toast.LENGTH_LONG).show()
            }


            R.id.tv_register -> {

                if (TextUtils.isEmpty(ed_phoneNumber.text.toString())) {

                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_LONG).show()
                } else if (TextUtils.isEmpty(ed_smsCode.text.toString())) {

                    Toast.makeText(this, "请输入短信验证码", Toast.LENGTH_LONG).show()
                } else if (TextUtils.isEmpty(ed_passWord.text.toString())) {

                    Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show()
                } else if (!ed_passWord.text.toString().equals(ed_confirmPassWord.text.toString())) {

                    Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_LONG).show()
                } else if (!read_agreement.isChecked) {

                    Toast.makeText(this, "请先阅读并同意开户协议", Toast.LENGTH_LONG).show()

                } else {
                    //注册


                }


            }


            //登录
            R.id.tv_login -> {


            }

        }

    }


    override fun getLayoutId(): Int {

        return R.layout.activity_register
    }


    override fun initData() {

        tv_register.setOnClickListener(this)
        tv_sendSmsCode.setOnClickListener(this)
        tv_open_agreement.setOnClickListener(this)
        select_agreement_layout.setOnClickListener(this)
        ck_passWord_state.setOnClickListener(this)
        ck_confirm_passWord_state.setOnClickListener(this)
        tv_login.setOnClickListener(this)



    }

}

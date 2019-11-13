package com.moran.baseproject.activity.login

import android.view.View
import android.widget.Toast
import com.moran.base.activity.BasicsActivity
import com.moran.baseproject.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BasicsActivity() ,View.OnClickListener{


    override fun onClick(view: View?) {

        when(view!!.id){

            R.id.tv_register ->{

                Toast.makeText(this,"不可注册",Toast.LENGTH_SHORT).show()
            }

            else ->{

                Toast.makeText(this,"啦啦啦",Toast.LENGTH_LONG).show()


            }
        }

    }


    override fun getLayoutId(): Int {

        return R.layout.activity_register
    }


    override fun initData() {

        tv_register.setOnClickListener(this)





    }



}

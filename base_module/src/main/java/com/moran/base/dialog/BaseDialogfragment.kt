package com.moran.base.dialog

import android.os.Bundle
import android.support.annotation.StyleRes
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.*
import com.moran.base.R

abstract class BaseDialogfragment : DialogFragment() {


    //dimAmount在0.0f和1.0f之间，0.0f完全不暗，即背景是可见的，1.0f时候，背景全部变黑暗。
    private var dimAmount = 0.5f

    private var mRootView : View? = null

    //透明度
    private var alpha = 1f

    private var width = WindowManager.LayoutParams.WRAP_CONTENT

    private var height = WindowManager.LayoutParams.WRAP_CONTENT

    protected var gravity  = Gravity.CENTER


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDialogStyle(STYLE_NO_TITLE, R.style.BaseDialogFragmentStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        mRootView = inflater.inflate(getLayoutId(),container,false)

        initView()
        initData()



        return mRootView
    }

    override fun onStart() {
        super.onStart()


        if (this.dialog != null){

            this.dialog!!.setCancelable(isCancel())

            dialog!!.setCanceledOnTouchOutside(isCancel())

            val window = dialog.window


            if (window != null){
                val params = window.attributes
                params.alpha = alpha
                params.dimAmount = dimAmount
                params.width = width
                params.height = height

                params.gravity = gravity

                window.attributes =params
            }



        }


    }



    fun findViewById(id : Int) : View{


        return mRootView!!.findViewById(id)

    }



    //设置dialog的style和主题
    protected open fun setDialogStyle(style : Int, @StyleRes theme : Int){

        super.setStyle(style,theme)

    }

    //
    protected open fun setAlpha(alpha : Float){

        this.alpha = alpha
    }

    protected open fun setDimAmount(dimAmount : Float){

      this.dimAmount = dimAmount

    }






    protected fun setLayoutParams(width: Int,height : Int){
        this.width = width
        this.height = height
    }


    protected open fun setLayoutGravity(gravity : Int){
        this.gravity = gravity
    }


    override fun dismiss() {
        if (dialog != null && dialog.isShowing){
            dialog.dismiss()
        }

    }


    //布局id
    abstract fun getLayoutId() : Int

    //初始化控件
    abstract fun initView()

    //初始化数据
    abstract fun initData()
    //点击外部是否可关闭
    abstract fun isCancel() : Boolean








}
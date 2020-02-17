package com.moran.base.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.moran.base.R

abstract class BaseDialog {




    private var inflater: LayoutInflater

    protected var context: Context

    private var themeResId: Int = R.style.mystyle

    private var mRootView: View? = null

    open var dialog: Dialog? = null


    //dimAmount在0.0f和1.0f之间，0.0f完全不暗，即背景是可见的，1.0f时候，背景全部变黑暗。
    private var dimAmount = 0.5f
    fun setDimAmount (dimAmount : Float){
        this.dimAmount = dimAmount
    }

    //透明度 1不透明，0全透明
    private var alpha = 1f
    fun setAlpha(alpha : Float){

        this.alpha = alpha

    }



    var confirm_btnClickListener: DialogInterface.OnClickListener? = null
        set(value) {
            field = value
        }


    var cancel_btnClickListener: DialogInterface.OnClickListener? = null
        set(value) {
            field = value
        }


    constructor(context: Context) : this(context, R.style.mystyle)

    constructor(context: Context, themeResId: Int) {

        this.context = context
        this.themeResId = themeResId

        inflater = LayoutInflater.from(context)


    }


    fun createDialog() {

        dialog = Dialog(context, themeResId)


        mRootView = inflater.inflate(getLayoutId(), null)

        initView()

        initData()


        dialog?.setCanceledOnTouchOutside(isCancel())

        dialog?.setCancelable(isCancel())

        dialog?.setContentView(mRootView)

        val window = dialog!!.window


        if (window != null) {
            val params = window.attributes
            params.alpha = alpha
            params.dimAmount = dimAmount
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            window.attributes = params

            initWindow(window)
        }
    }

    //布局id
    protected abstract fun getLayoutId(): Int

    //初始化控件
    protected abstract fun initView()

    //初始化数据
    protected abstract fun initData()

    //点击外部是否可关闭
    protected abstract fun isCancel(): Boolean


    protected  fun initWindow(window: Window){

    }


    fun <V : View> findViewById(viewId: Int): V {

        return mRootView!!.findViewById(viewId) as V

    }


    fun showDialog() {
        if (dialog != null){

            dialog?.show()
        }

    }

    fun onDismiss(){
        if (dialog != null){

            dialog?.dismiss()
        }
    }
}
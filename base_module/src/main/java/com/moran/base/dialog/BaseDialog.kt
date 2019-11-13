package com.moran.base.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import com.moran.base.R

abstract class BaseDialog {


    private var inflater: LayoutInflater

    protected var context: Context? = null

    private var themeResId: Int = R.style.mystyle

    private var mRootView: View? = null

    protected var dialog: Dialog


    //dimAmount在0.0f和1.0f之间，0.0f完全不暗，即背景是可见的，1.0f时候，背景全部变黑暗。
     var dimAmount = 0.5f
        set(value) {
            field = value
        }

    //透明度 1不透明，0全透明
     var alpha = 1f
        set(value) {
            field = value
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

        dialog = createDialog()

    }


    private fun createDialog(): Dialog {

        val dialog = Dialog(context!!, themeResId)


        mRootView = inflater.inflate(getLayoutId(), null)

        initView()

        initData()

        dialog.setContentView(mRootView)

        dialog.setCanceledOnTouchOutside(isCancel())

        dialog.setCancelable(isCancel())

        val window = dialog.window

        if (window != null) {
            val params = window.attributes
            params.alpha = alpha
            params.dimAmount = dimAmount


            window.attributes = params
        }

        return dialog
    }

    //布局id
    protected abstract fun getLayoutId(): Int

    //初始化控件
    protected abstract fun initView()

    //初始化数据
    protected abstract fun initData()

    //点击外部是否可关闭
    protected abstract fun isCancel(): Boolean


    fun <V : View> findViewById(viewId: Int): V {

        return mRootView!!.findViewById(viewId) as V

    }


    fun showDialog() {

        dialog!!.show()
    }
}
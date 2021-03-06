package com.moran.base.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.moran.base.R
import com.moran.base.utils.LogUtils
import kotlinx.android.synthetic.main.base_title.view.*

class CustomLinearLayout : LinearLayout, View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ll_base_title_back ->
                clickListener?.onFinish()
        }

    }

    /**
     * 布局
     * */
    private var baseLayoutId: Int = R.layout.base_title

    /**
     * 返回图标
     * */
    private var backIcon: Int = R.drawable.back


    /**
     * title文字
     * */
    private var titleText: Int = R.string.app_name
    /**
     * title文字大小
     * */
    private var titleTextSize: Int = 16

    private var titleTextColor: Int = resources.getColor(android.R.color.white)

    /**
     * 默认title颜色
     * */
    private var titleLayoutBackground: Int = resources.getColor(R.color.colorRed)


    /**
     * 是否隐藏返回键
     * */
    private var isHideBack: Boolean = false


    private var hideTitleLayout = false


      var clickListener: onFinishClickListener? = null

    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        orientation = VERTICAL
        val arrayType: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomLinearLayout)
        baseLayoutId = arrayType.getResourceId(R.styleable.CustomLinearLayout_layout, R.layout.base_title)
        titleLayoutBackground = arrayType.getColor(R.styleable.CustomLinearLayout_titleBackground, resources.getColor(R.color.colorRed))
        backIcon = arrayType.getResourceId(R.styleable.CustomLinearLayout_backIcon, R.drawable.back)
        titleText = arrayType.getResourceId(R.styleable.CustomLinearLayout_titleText, R.string.must_set_title)
        titleTextSize = arrayType.getInt(R.styleable.CustomLinearLayout_titleTextSize,titleTextSize)

        LogUtils.i("title文字大小", titleTextSize)


        titleTextColor = arrayType.getColor(
            R.styleable.CustomLinearLayout_titleTextColor,
            resources.getColor(android.R.color.white)
        )
        isHideBack = arrayType.getBoolean(R.styleable.CustomLinearLayout_hideBack, false)

        hideTitleLayout = arrayType.getBoolean(R.styleable.CustomLinearLayout_hideTitleLayout,false)

        arrayType.recycle()
        initData()
    }

    private fun initData() {


        
        if (!hideTitleLayout){
            LayoutInflater.from(context).inflate(baseLayoutId, this, true)
            rl_base_title_menu_.setBackgroundColor(titleLayoutBackground)
            iv_base_title_setting.setImageResource(backIcon)
            tv_base_title_text.setText(titleText)
            tv_base_title_text.setTextColor(titleTextColor)

            tv_base_title_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,titleTextSize.toFloat())

            ll_base_title_back.setOnClickListener(this)

            if (isHideBack) {
                iv_base_title_setting.visibility = View.GONE
            }
        }

    }


    interface onFinishClickListener {
        fun onFinish()
    }
}
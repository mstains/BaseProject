package com.moran.base.view.webView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.support.annotation.ColorRes
import android.util.AttributeSet
import android.view.View
import com.moran.base.utils.LogUtils
import com.moran.base.utils.Utils

class ProgressRectView : View {


    private var left = 0f

    private var right = 0f


    private var screenWidth = 0

    var viewSlideSpace = 0f
        set(value) {
            field = value
        }
        get() {
            return field
        }
    var mBarHeight = 8f
        set(value) {
            field = value
        }


    private var mPaint: Paint


    constructor(context: Context) : super(context, null) {

    }

    init {
        screenWidth = Utils.getInstance().getScreenWidth(context)
        mPaint = Paint()
        mPaint.style = Paint.Style.FILL

        viewSlideSpace = screenWidth / 100f
        right = viewSlideSpace
    }


    fun setColor(@ColorRes colorId: Int) {
        mPaint.color = context.resources.getColor(colorId)
    }

    fun setStrokeWidth(strokeWidth: Float) {
        mPaint.strokeWidth = strokeWidth

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val rectf = RectF(left, 0f, right, mBarHeight)
        canvas!!.drawRect(rectf, mPaint)
    }


    fun moveView(translationX: Int) {
        LogUtils.e("translationX", translationX)
        right = viewSlideSpace * translationX
        invalidate()
    }


}
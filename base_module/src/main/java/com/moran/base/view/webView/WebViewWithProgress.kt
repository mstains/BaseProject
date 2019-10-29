package com.moran.base.view.webView

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import com.moran.base.R
import com.moran.base.utils.LogUtils

class WebViewWithProgress : RelativeLayout {


    private val webView: WebView



    private var progressBar : ProgressRectView? = null

    private  var progressBar_circle: RelativeLayout? = null

    //默认
    private var mProgressStyle = ProgressStyle.Horizontal.ordinal


    private val DEFAULT_BAR_HEIGHT = 8


    private var mBarHeight = DEFAULT_BAR_HEIGHT


    private var progressDrawable = R.color.colorRed


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.WebViewWithProgress)

        mProgressStyle = attributes.getInt(
            R.styleable.WebViewWithProgress_progressStyle,
            ProgressStyle.Horizontal.ordinal
        )

        mBarHeight = attributes.getDimensionPixelSize(
            R.styleable.WebViewWithProgress_barHeight,
            DEFAULT_BAR_HEIGHT
        )



        attributes.recycle()
    }


    init {

        webView = WebView(context)

        val webSettings = webView.settings

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        //允许js代码
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true

        webSettings.domStorageEnabled = true

        webSettings.javaScriptCanOpenWindowsAutomatically = true
        //缓存模式
        webSettings.cacheMode = WebSettings.LOAD_DEFAULT
        //设置可以访问文件/，是否可访问Content Provider的资源，默认值 true
        webSettings.allowContentAccess = true
        // 是否可访问本地文件，默认值 true
        webSettings.allowFileAccess = true
        //支持自动加载图片
        webSettings.loadsImagesAutomatically = true
        webSettings.useWideViewPort = true
        webSettings.defaultTextEncodingName = "UTF-8"
        // 是否允许通过file url加载的Javascript读取本地文件，默认值 false
        webSettings.allowFileAccessFromFileURLs = false
        // 是否允许通过file url加载的Javascript读取全部资源(包括文件,http,https)，默认值 false
        webSettings.allowUniversalAccessFromFileURLs = false
        webSettings.builtInZoomControls = true
        webSettings.setSupportZoom(true)
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        //设定缩放控件隐藏
        webSettings.displayZoomControls = false

        webView.webChromeClient = object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)

                LogUtils.e("newProgress",newProgress)

                if (mProgressStyle == ProgressStyle.Horizontal.ordinal){

                    progressBar!!.visibility = View.VISIBLE

                    progressBar!!.moveView(newProgress)

                }
                else{

                    progressBar_circle!!.visibility = View.VISIBLE
                }


            }
        }

        this.addView(webView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

        if (mProgressStyle == ProgressStyle.Horizontal.ordinal) {

            progressBar = ProgressRectView(context)

            progressBar!!.setColor(progressDrawable)

            progressBar!!.mBarHeight = mBarHeight.toFloat()

            this.addView(progressBar, LayoutParams.MATCH_PARENT, mBarHeight)

        } else {

            progressBar_circle = LayoutInflater.from(context).inflate(
                R.layout.progress_circle,
                null
            ) as RelativeLayout

            this.addView(progressBar_circle, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }


    }


    @SuppressLint("JavascriptInterface")
    fun addJavascriptInterface(clazz: Any, name: String) {
        webView.addJavascriptInterface(clazz, name)

    }





     fun loadUrl(url : String){

        webView.loadUrl(url)

    }








    enum class ProgressStyle {

        Horizontal,
        Circle
    }





}
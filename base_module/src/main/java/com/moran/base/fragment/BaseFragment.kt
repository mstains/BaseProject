package com.moran.base.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment



/**
  * @Package:
  * @ClassName:
  * @Description:    Fragment基类
  * @Author:         moran
  * @CreateDate:     2019-11-01 21:19
  * @UpdateUser:     更新者：moran
  * @UpdateDate:     2019-11-01 21:19
  * @UpdateRemark:   更新说明：
  * @Version:        1.0
 */
 abstract class BaseFragment : Fragment() {

    protected var activity : Activity? = null

    protected var mContext : Context? = null

    protected var mRootView : View? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
        mContext = context
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mRootView = layoutInflater.inflate(getLayoutId(),container,false)

        return mRootView

        initView()


        initData()

    }



     /**
      * 寻找控件id
      * @method
      * @date: 2019-11-01 21:24
      * @author: moran
      * @param viewId 控件id
      */
    fun <V : View> findViewById(viewId: Int): V {

        return mRootView!!.findViewById(viewId) as V

    }


     /**
      * 初始化参数
      * @method
      * @date: 2019-11-01 21:19
      * @author: moran
      * @param
      * @return
      */
    abstract fun initData()


     /**
      * 初始化view
      * @method
      * @date: 2019-11-01 21:20
      * @author: moran
      * @param
      * @return
      */
    abstract fun initView()


      /**
       * 获取布局Id
       * @method
       * @date: 2019-11-01 21:18
       * @author: moran
       * @return 布局id
       */
    abstract fun getLayoutId() : Int




}
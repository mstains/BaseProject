package com.moran.base.adapter

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View

class BaseViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    private  var views : SparseArray<View> = SparseArray()


     fun <V : View > getView(viewId : Int) : V {


        var view  = views[viewId]
        if (view == null){
            view = itemView.findViewById(viewId)
            views.put(viewId,view)
        }

        return view as V
    }


//    fun <T : View> getView(viewId: Int): T {
//        var view: View? = views.get(viewId)
//        if (view == null) {
//            view = itemView.findViewById(viewId)
//            views.put(viewId, view)
//        }
//        return view as T?
//    }



}
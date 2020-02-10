package com.moran.base.adapter

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView

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




}
package com.moran.base.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager

abstract  class  AdapterBase<T> constructor(context: Context,list: List<T>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    protected  var list : List<T>


    protected  var mContext : Context


    protected  var layoutInflater: LayoutInflater

    private var itemClickListener: ItemClickListener<T>? = null


    init {
        this.list = list
        this.mContext = context
        layoutInflater = LayoutInflater.from(context)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val rootView = layoutInflater.inflate(getLayoutId(viewType),parent,false)


        val viewHolder  = BaseViewHolder(rootView)

        return viewHolder
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        bindData(holder as BaseViewHolder,list.get(position),position)

        holder.itemView.setOnClickListener {

            if (itemClickListener != null){
                itemClickListener!!.onItemClickListener(list.get(position),position)
            }
        }
    }


    protected abstract fun getLayoutId (viewType : Int) : Int


    protected abstract fun bindData(holder: BaseViewHolder, t : T,position: Int)


     open fun setOnItemClickListener( itemClickListener: ItemClickListener<T>){

        this.itemClickListener = itemClickListener
    }




    protected fun restData(list : List<T>){
        this.list = list
        notifyDataSetChanged()
    }


    protected fun restData(list : List<T>,position: Int){
        this.list = list
        notifyItemChanged(position)
    }



}
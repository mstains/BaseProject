package com.moran.base.utils.imageLoad

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoad {


    companion object{


        fun loadImage(context: Context,url: String,imageView: ImageView){

            Glide.with(context).load(url).into(imageView)

        }


    }

}
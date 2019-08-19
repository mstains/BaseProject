package com.moran.base.http



class ApiRetrofit private constructor(){



    companion object{

        private var instance : ApiRetrofit? = null
        get(){
          if (field == null){
              field = ApiRetrofit()
          }
            return field
        }

        @Synchronized
        fun get(): ApiRetrofit{

            return instance!!
        }
    }



}
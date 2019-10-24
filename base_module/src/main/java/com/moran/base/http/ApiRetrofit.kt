package com.moran.base.http

import com.moran.base.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.protobuf.ProtoConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


class ApiRetrofit private constructor(){

    private  var mOkHttpClient:  OkHttpClient
    private  var retrofit:Retrofit
    var apiServer: ApiServer
    init {
        mOkHttpClient = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(ProtoConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient).build()
        apiServer = retrofit.create(ApiServer::class.java)
    }

    companion object{
        private val TIMEOUT_READ :Long = 60L
        private val TIMEOUT_CONNECTION : Long = 15L
        private val BASE_URL : String = BuildConfig.HTTP_BASE
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
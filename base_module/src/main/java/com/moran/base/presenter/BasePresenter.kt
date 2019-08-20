package com.moran.base.presenter

import com.google.gson.Gson
import com.moran.base.http.ApiRetrofit
import com.moran.base.http.ApiServer
import com.moran.base.http.BaseObserver
import com.moran.base.http.callback.BaseCallback
import com.moran.base.http.callback.JsonCallBack
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject


open class BasePresenter<out V : BaseView>(val baseView: V) {

    private var compositeDisposable : CompositeDisposable? = null

    private val apiServer: ApiServer
    init {
        apiServer = ApiRetrofit.get().apiServer
    }





    fun <T> getExecute(url:String,disposable: BaseCallback<T>){
        if (compositeDisposable == null){
            compositeDisposable = CompositeDisposable()
        }

        compositeDisposable!!.add(apiServer.getExecute(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseBody>() {
                override fun onStart() {

                    disposable.onStart()

                }
                override fun onComplete() {
                    disposable.onComplete()
                }
                override fun onNext(responseBody : ResponseBody) {
                    //disposable.onSuccess("23123131")

                }

                override fun onError(e: Throwable) {
                    disposable.onComplete()
                }
            }))
//        compositeDisposable!!.add(apiServer.getExecute(url).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
    }

    fun <T> getExecute(url: String,clazz: Class<T>,jsonCallBack: JsonCallBack<T>){
        if (compositeDisposable == null){
            compositeDisposable = CompositeDisposable()
        }

        compositeDisposable!!.add(apiServer.getExecute(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : BaseObserver<ResponseBody>() {
                override fun onSuccess(t: ResponseBody) {
                    val json : String = t.string()
                    val gson = Gson()
                    val t:T = gson.fromJson(json,clazz)
                    jsonCallBack.onSuccess(t)
                }
            }))
    }

    fun <T> postExecute(url: String, map: HashMap<String, String>, clazz: Class<T>, jsonCallBack: JsonCallBack<T>){

        val requestBody =   RequestBody.create(MediaType.parse("application/octet-stream"),JSONObject(map).toString())

        if (compositeDisposable == null){
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable!!.add(apiServer.postExecute(url,requestBody)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : BaseObserver<ResponseBody>() {
                override fun onSuccess(t: ResponseBody) {
                    val json : String = t.string()
                    val gson = Gson()
                    val result:T = gson.fromJson(json,clazz)
                    jsonCallBack.onSuccess(result)
                }
            }))
    }


    fun parseBody(map:HashMap<String,String>) : String{
        return JSONObject(map).toString()
    }

}





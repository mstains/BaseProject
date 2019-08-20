package com.moran.base.http

import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface ApiServer {

    /**
     * get请求
     * @date: 2019/8/19 13:29
     * @author: moran
     * @param url 请求链接
     * @return Observable<ResponseBody> 返回请求信息
     */
    @GET
    fun  getExecute(@Url  url : String) : Observable<ResponseBody>

    /**
     * post请求
     * @date: 2019/8/19 13:29
     * @author: moran
     * @param url 请求链接
     * @return Observable<ResponseBody> 返回请求信息
     */
    @POST
    fun <T> postExecute(@Url url: String) : Observable<T>


    /**
     * post请求
     * @date: 2019/8/19 13:29
     * @author: moran
     * @param url 请求链接
     * @param body 请求信息
     * @return Observable<ResponseBody> 返回请求信息
     */
    @POST
    fun <T> postExecute(@Url url: String,@Body body: RequestBody) : Observable<T>

    /**
     * 单个文件上送
     * @date: 2019/8/19 13:29
     * @author: moran
     * @param url 请求链接
     * @param part 上送文件信息
     * @return Observable<ResponseBody> 返回请求信息
     */
    @Multipart
    fun <T> updateMultipart(@Url url:String, @Part part : MultipartBody.Part) : Observable<T>

    /**
     * 多文件上送
     * @date: 2019/8/19 13:29
     * @author: moran
     * @param url 请求链接
     * @param listPart 上送文件集合
     * @return Observable<ResponseBody> 返回请求信息
     */
    @Multipart
    fun <T> updateListMultipart(@Url url:String,@Part listPart : List<MultipartBody.Part>): Observable<T>





    /**
     * 文件下载
     * @param url 下载链接
     * */
    @Streaming
    @GET
    fun downloadFile(@Url url: String) : Observable<ResponseBody>



    /**
     * post文件下载
     * @param url 下载地址
     * @param body 请求参数
     * */
    @Streaming
    @POST
    fun downloadFile(@Url url: String,@Body body: RequestBody) : Observable<ResponseBody>


}
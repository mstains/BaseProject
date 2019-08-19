package com.moran.base.http;

import com.moran.base.BuildConfig;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 *  @ProjectName:
 * @Package:        com.moran.base.http
 * @ClassName:      ApiServer
 * @Description:     Retrofit ApiServer类
 * @Author:         moran
 * @CreateDate:     2019/8/19 13:31
 * @UpdateUser:     更新者：
 * @UpdateDate:     2019/8/19 13:31
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
public interface ApiServer {

    /**
     * get请求
     * @date: 2019/8/19 13:29
     * @author: moran
     * @param url 请求链接
     * @return Observable<ResponseBody> 返回请求信息
     */
    @GET
    Observable<ResponseBody>getExecute(@Url String url);


    /**
     * post请求
     * @date: 2019/8/19 13:29
     * @author: moran
     * @param url 请求链接
     * @return Observable<ResponseBody> 返回请求信息
     */
    @POST
    Observable<ResponseBody> postExecute(@Url String url);


    /**
     * post请求
     * @date: 2019/8/19 13:29
     * @author: moran
     * @param url 请求链接
     * @param body 请求信息
     * @return Observable<ResponseBody> 返回请求信息
     */
    @POST
    Observable<ResponseBody> postExecute(@Url String url,@Body RequestBody body);
}

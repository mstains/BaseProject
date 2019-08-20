package com.moran.base.utils.imageLoad;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ObjectKey;

import java.io.File;

/**
 * @ProjectName:
 * @Package:
 * @ClassName:      ImageLoad
 * @Description:     图片加载
 * @Author:         moran
 * @CreateDate:     2019/6/18 15:25
 * @UpdateUser:     更新者：
 * @UpdateDate:     2019/6/18 15:25
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
public class ImageLoad {

    private static ImageLoad instance = null;

    public static ImageLoad getInstance() {
        if (instance == null) {
            synchronized (ImageLoad.class){
                instance = new ImageLoad();
            }

        }
        return instance;
    }

    /**
     * @param activity  上下文对象
     * @param url       加载图片url
     * @param imageView imageView控件
     */
    public void loadImage(Activity activity, String url, ImageView imageView) {
        loadImageUrlActivity(activity,url,imageView);
    }


    public void loadImage(Activity activity, byte[] data, ImageView imageView) {
        loadImageByteActivity(activity,data,imageView);
    }

    public void loadImage(Activity activity, String url,RequestOptions options, ImageView imageView ){
        loadImageUrlActivity(activity,url,options,imageView);
    }
    /***
     * @param activity 上下文对象
     * @param url 加载图片url
     * @param imageView imageView控件
     * @param resourceId 占位图
     * @param errorId 图片加载失败占位图
     *
     * */
    public void loadImage(Activity activity, String url, ImageView imageView, int resourceId, int errorId, String signature) {

        RequestOptions options = new RequestOptions().placeholder(resourceId).error(errorId).diskCacheStrategy(DiskCacheStrategy.NONE).signature(new ObjectKey(signature)).skipMemoryCache(true);

        loadImageUrlActivity(activity,url,options,imageView);
    }

    /***
     * @param activity 上下文对象
     * @param url 加载图片url
     * @param imageView imageView控件
     *
     * */
    public void loadImage(Activity activity, String url, ImageView imageView, String signature) {

        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).signature(new ObjectKey(signature)).skipMemoryCache(true);

        loadImageUrlActivity(activity,url,options,imageView);
    }


    /***
     * @param context 上下文对象
     * @param url 加载图片url
     * @param imageView imageView控件
     * @param resourceId 占位图
     * @param errorId 图片加载失败占位图
     *
     * */
    public void loadImage(Context context, String url, ImageView imageView, int resourceId, int errorId, String signature) {

        RequestOptions options = new RequestOptions().placeholder(resourceId).error(errorId).diskCacheStrategy(DiskCacheStrategy.NONE).signature(new ObjectKey(signature)).skipMemoryCache(true);

        loadImageUrlContext(context,url,options,imageView);
    }

    public void loadImage(Context context, String url, ImageView imageView) {

        RequestOptions options = new RequestOptions().dontAnimate();
        loadImageUrlContext(context,url,options,imageView);
    }

    public void loadImage(Context context, File file, ImageView imageView) {
        RequestOptions options = new RequestOptions().dontAnimate();
        loadImageFileContext(context,file,options,imageView);
    }


    public void loadImage(Context context, String url, int placeholderId, ImageView imageView) {
        RequestOptions options = new RequestOptions().placeholder(placeholderId);
        loadImageUrlContext(context,url,options,imageView);
    }

    public void loadImage(Context context, @DrawableRes int resid, ImageView imageView) {
        loadImageDrawableResContext(context,resid,imageView);
    }

    public void loadImage(Context context, @DrawableRes int resid, int placeholderId, ImageView imageView) {

        RequestOptions options = new RequestOptions().placeholder(placeholderId);
        loadImageDrawableResContext(context,resid,options,imageView);
    }

    public void loadImage(Context context, byte[] data, ImageView imageView) {
        loadImageByteContext(context,data,imageView);
    }

    /**
     * @param context
     * @param url
     * @param imageView
     * @param signature //添加签名 防止图片地址不变 但是实际图片已经改变了
     */
    public void loadImageWithSignature(Context context, String url, ImageView imageView, String signature) {
        RequestOptions options = new RequestOptions().signature(new ObjectKey(signature)).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.ALL);
        loadImageUrlContext(context,url,options,imageView);
    }

    /**
     * @param context
     * @param url
     * @param imageView
     * @param signature //添加签名 防止图片地址不变 但是实际图片已经改变了
     */
    public void loadImageWithSignatureAnimate(Context context, String url, ImageView imageView, String signature) {

        if (context == null) {
            return;
        }
        RequestOptions options = new RequestOptions().dontAnimate().signature(new ObjectKey(signature));
        loadImageUrlContext(context,url,options,imageView);
    }




    /**
     * @param fragment   上下文对象
     * @param url        加载图片url
     * @param imageView  imageView控件
     * @param resourceId 占位图
     */
    public void loadImage(Fragment fragment, String url, ImageView imageView, int resourceId) {

        RequestOptions options = new RequestOptions().placeholder(resourceId).skipMemoryCache(true);

        loadImageUrlFragment(fragment,url,options,imageView);
    }


    /**
     * @param fragment      上下文对象
     * @param url           加载图片url
     * @param imageView     imageView控件
     * @param placeholderId 占位图
     * @param errorId       图片加载失败占位图
     */
    public void loadImage(Fragment fragment, String url, ImageView imageView, int placeholderId, int errorId) {

        RequestOptions options = new RequestOptions().placeholder(placeholderId).error(errorId).skipMemoryCache(true);
        loadImageUrlFragment(fragment,url,options,imageView);
    }


    /**
     * @param fragment  上下文对象
     * @param url       加载图片url
     * @param imageView imageView控件
     */
    public void loadImage(Fragment fragment, String url, ImageView imageView) {
        if (fragment == null) {
            return;
        }
        RequestOptions options = new RequestOptions().skipMemoryCache(true);
        loadImageUrlFragment(fragment,url,options,imageView);
    }




    public void loadImage(Fragment fragment, @DrawableRes int resid, ImageView imageView) {

        loadImageDrawableResFragment(fragment,resid,imageView);

    }




    /**
     * @method
     * @description activity加载图片
     * @date: 2019/6/18 15:15
     * @author: moran
     * @param
     * @return
     */
    private void loadImageUrlActivity(Activity activity, String url, ImageView imageView){

        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(url).into(imageView);

    }

    /**
     * @method
     * @description 加载uri地址图片
     * @date: 2019/6/18 15:42
     * @author: moran
     * @param activity 上下文对象
     * @param url 图片地址
     * @param imageView image组件
     * @return
     */
    private void loadImageUrlActivity(Activity activity, String url, RequestOptions options, ImageView imageView){

        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(url).apply(options).into(imageView);
    }


    /**
     * @method
     * @description 加载uri地址图片
     * @date: 2019/6/18 15:42
     * @author: moran
     * @param activity 上下文对象
     * @param resid 资源文件
     * @param imageView image组件
     * @return
     */
    private void loadImageDrawableResActivity(Activity activity,@DrawableRes int resid,ImageView imageView){
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(resid).into(imageView);

    }
    /**
     * @method
     * @description 加载uri地址图片
     * @date: 2019/6/18 15:42
     * @author: moran
     * @param activity 上下文对象
     * @param resid 资源文件
     * @param options glide配置
     * @param imageView image组件
     * @return
     */
    private void loadImageDrawableResActivity(Activity activity,@DrawableRes int resid,RequestOptions options,ImageView imageView){
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(resid).apply(options).into(imageView);

    }



    /**
     * @method
     * @description 加载uri地址图片
     * @date: 2019/6/18 15:42
     * @author: moran
     * @param activity 上下文对象
     * @param data 图片byte流
     * @param imageView image组件
     * @return
     */
    private void loadImageByteActivity(Activity activity, byte[] data, ImageView imageView){
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(data).into(imageView);
    }

    /**
     * @method
     * @description 加载uri地址图片
     * @date: 2019/6/18 15:42
     * @author: moran
     * @param activity 上下文对象
     * @param data 图片byte流
     * @param options gilde配置
     * @param imageView image组件
     * @return
     */
    private void loadImageByteActivity(Activity activity, byte[] data,RequestOptions options, ImageView imageView){
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(data).apply(options).into(imageView);
    }


    /**
     * @method
     * @description 加载uri地址图片
     * @date: 2019/6/18 15:42
     * @author: moran
     * @param activity 上下文对象
     * @param uri 图片uri地址
     * @param imageView image组件
     * @return
     */
    private void loadImageUriActivity(Activity activity, Uri uri,ImageView imageView){

        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(uri).into(imageView);
    }

    /**
     * @method
     * @description 加载uri地址图片
     * @date: 2019/6/18 15:42
     * @author: moran
     * @param activity 上下文对象
     * @param uri 图片uri地址
     * @param options glide配置
     * @param imageView image组件
     * @return
     */
    private void loadImageUriActivity(Activity activity, Uri uri,RequestOptions options,ImageView imageView){

        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(uri).apply(options).into(imageView);
    }

    /**
     * @method
     * @description 加载file地址图片
     * @date: 2019/6/18 15:42
     * @author: moran
     * @param activity 上下文对象
     * @param file 图片file地址
     * @param imageView image组件
     * @return
     */
    private void loadImageFileActivity(Activity activity,File file,ImageView imageView){
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(file).into(imageView);

    }

    /**
     * @method
     * @description 加载file地址图片
     * @date: 2019/6/18 15:42
     * @author: moran
     * @param activity 上下文对象
     * @param file 图片file地址
     * @param options glide配置
     * @param imageView image组件
     * @return
     */
    private void loadImageFileActivity(Activity activity,File file,RequestOptions options,ImageView imageView){

        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Glide.with(activity).load(file).apply(options).into(imageView);

    }


    /**
     * @method
     * @description fragment 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param fragment 上下文对象
     * @param url 图片url
     * @param imageView imageView控件
     * @return
     */
    private void loadImageFragment(Fragment fragment, String url, ImageView imageView){
        if (fragment != null){
            loadImageUrlActivity(fragment.getActivity(),url,imageView);
        }


    }

    /**
     * @method
     * @description fragment 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param fragment 上下文对象
     * @param url 图片url
     * @param options glide设置
     * @param imageView imageView控件
     * @return
     */
    private void loadImageUrlFragment(Fragment fragment, String url, RequestOptions options, ImageView imageView){
        if (fragment != null){
            loadImageUrlActivity(fragment.getActivity(),url,options,imageView);
        }

    }


    /**
     * @method
     * @description fragment 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param fragment 上下文对象
     * @param resid 资源文件
     * @param imageView imageView控件
     * @return
     */
    private void loadImageDrawableResFragment(Fragment fragment, @DrawableRes int resid, ImageView imageView){
        if (fragment != null){
            loadImageDrawableResActivity(fragment.getActivity(),resid,imageView);
        }

    }


    /**
     * @method
     * @description fragment 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param fragment 上下文对象
     * @param resid 资源文件
     * @param options glide设置
     * @param imageView imageView控件
     * @return
     */
    private void loadImageDrawableResFragment(Fragment fragment, @DrawableRes int resid, RequestOptions options, ImageView imageView){
        if (fragment != null){
            loadImageDrawableResActivity(fragment.getActivity(),resid,options,imageView);
        }

    }





    /**
     * @method
     * @description context 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param context 上下文对象
     * @param url 图片url
     * @param imageView imageView控件
     * @return
     */
    private void loadImageUrlContext(Context context,String url,ImageView imageView){
        if (context != null){
            if (context instanceof Activity){
                loadImageUrlActivity((Activity) context,url,imageView);
            }
            else {
                Glide.with(context).load(url).into(imageView);
            }
        }

    }
    /**
     * @method
     * @description context 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param context 上下文对象
     * @param url 图片url
     * @param options glide设置
     * @param imageView imageView控件
     * @return
     */
    private void loadImageUrlContext(Context context,String url,RequestOptions options,ImageView imageView){

        if (context != null){
            if (context instanceof Activity){
                loadImageUrlActivity((Activity) context,url,options,imageView);
            }
            else {
                Glide.with(context).load(url).apply(options).into(imageView);
            }
        }

    }

    /**
     * @method
     * @description context 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param context 上下文对象
     * @param data 图片byte流
     * @param imageView imageView控件
     * @return
     */
    private void loadImageByteContext(Context context,byte [] data,ImageView imageView){
        if (context != null){
            if (context instanceof Activity){
                loadImageByteActivity((Activity) context,data,imageView);
            }
            else {
                Glide.with(context).load(data).into(imageView);
            }
        }
    }

    /**
     * @method
     * @description context 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param context 上下文对象
     * @param data 图片byte流
     * @param options glide设置
     * @param imageView imageView控件
     * @return
     */
    private void loadImageByteContext(Context context,byte [] data,RequestOptions options,ImageView imageView){
        if (context != null){
            if (context instanceof Activity){
                loadImageByteActivity((Activity) context,data,options,imageView);
            }
            else {
                Glide.with(context).load(data).apply(options).into(imageView);
            }
        }
    }


    /**
     * @method
     * @description context 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param context 上下文对象
     * @param resid 资源图片
     * @param imageView imageView控件
     * @return
     */
    private void loadImageDrawableResContext(Context context,@DrawableRes int resid,ImageView imageView){
        if (context != null){
            if (context instanceof Activity){
                loadImageDrawableResActivity((Activity) context,resid,imageView);
            }
            else {
                Glide.with(context).load(resid).into(imageView);
            }
        }

    }
    /**
     * @method
     * @description context 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param context 上下文对象
     * @param resid 资源图片
     * @param imageView imageView控件
     * @return
     */
    private void loadImageDrawableResContext(Context context,@DrawableRes int resid,RequestOptions options,ImageView imageView){
        if (context != null){
            if (context instanceof Activity){
                loadImageDrawableResActivity((Activity) context,resid,options,imageView);
            }
            else {
                Glide.with(context).load(resid).apply(options).into(imageView);
            }
        }

    }


    /**
     * @method
     * @description context 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param context 上下文对象
     * @param file 图片文件路径
     * @param imageView imageView控件
     * @return
     */
    private void loadImageFileContext(Context context,File file,ImageView imageView){
        if (context != null){
            if (context instanceof Activity){
                loadImageFileActivity((Activity) context,file,imageView);
            }
            else {
                Glide.with(context).load(file).into(imageView);
            }
        }

    }

    /**
     * @method
     * @description context 加载图片
     * @date: 2019/6/18 15:23
     * @author: moran
     * @param context 上下文对象
     * @param file 图片文件路径
     * @param options glide设置
     * @param imageView imageView控件
     * @return
     */
    private void loadImageFileContext(Context context,File file,RequestOptions options,ImageView imageView){

        if (context != null){
            if (context instanceof Activity){
                loadImageFileActivity((Activity) context,file,options,imageView);
            }
            else {
                Glide.with(context).load(file).apply(options).into(imageView);
            }
        }

    }

}

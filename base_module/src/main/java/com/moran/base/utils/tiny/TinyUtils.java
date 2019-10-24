package com.moran.base.utils.tiny;

import com.zxy.tiny.Tiny;
import com.zxy.tiny.callback.FileCallback;

import java.io.File;

/**
 *  @ProjectName:
 * @Package:        com.moran.utilsmodule.tiny
 * @ClassName:      TinyUtils
 * @Description:     图片压缩工具类
 * @Author:         moran
 * @CreateDate:     2019/8/8 8:58
 * @UpdateUser:     更新者：
 * @UpdateDate:     2019/8/8 8:58
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
public class TinyUtils {

    private static TinyUtils tinyUtils = null;


    public static TinyUtils getInstance() {
        synchronized (TinyUtils.class){
            if (tinyUtils == null){
                tinyUtils = new TinyUtils();
            }
        }
        return tinyUtils;
    }

    public void compressString(final String filePath,final ImageCallback<String> imageCallback){

        Tiny.getInstance().source(filePath).asFile().compress(new FileCallback() {
            @Override
            public void callback(boolean isSuccess, String outfile, Throwable t) {

                if (isSuccess){
                    imageCallback.callback(outfile);
                }
                else {
                    imageCallback.onError(filePath,t);
                }
            }
        });
    }



    public void compressFile(final String filePath, final ImageCallback<File> imageCallback){

        Tiny.getInstance().source(filePath).asFile().compress(new FileCallback() {
            @Override
            public void callback(boolean isSuccess, String outfile, Throwable t) {

                if (isSuccess){
                    imageCallback.callback(new File(outfile));
                }
                else {
                    imageCallback.onError(new File(filePath),t);
                }
            }
        });
    }






    public interface ImageCallback <T>{

        /**
         * 压缩成功
         * @param outfile 压缩图片路径
         * */
        void callback(T outfile);

        /**
         * 压缩失败
         * @param originalPath 原始路径
         * @param throwable 异常信息
         * */
        void onError(T originalPath, Throwable throwable);

    }
}

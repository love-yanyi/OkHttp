package com.mylove.okhttp;

import android.annotation.SuppressLint;
import android.content.Context;

import java.util.Map;

/**
 * @author myLove
 * @time 2017/11/2 14:41
 * @e-mail mylove.520.y@gmail.com
 * @overview
 */

public class OkHttpUtil {
    @SuppressLint("StaticFieldLeak")
    private static OkHttpUtil instance;
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    public static OkHttpUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (OkHttpUtil.class) {
                if (instance == null) {
                    instance = new OkHttpUtil();
                    mContext = context;
                }
            }
        }
        return instance;
    }

    public AutoRequest get(String url) {
        return AutoRequest.getInstance(mContext, url, RequestType.GET);
    }

    public AutoRequest post(String url) {
//        request(url, oMap, onOkHttpListener);
        return AutoRequest.getInstance(mContext, url, RequestType.POST);
    }

    public AutoRequest postUpFile(String url) {
        return AutoRequest.getInstance(mContext, url, RequestType.UP_FILE);
    }

    public AutoRequest postAll(String url) {
        return AutoRequest.getInstance(mContext, url, RequestType.UP_FILE);
    }

    @Deprecated
    public void postRequest(String url, Map<Object, Object> oMap, final onOkHttpListener<String, String> onOkHttpListener) {
//        request(url, oMap, onOkHttpListener);
    }
}

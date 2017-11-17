package com.mylove.okhttp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * @author myLove
 * @time 2017/11/7 16:08
 * @e-mail mylove.520.y@gmail.com
 * @overview 网络工具类
 */

 class InternetUtil {
    /**
     * 判断是否有网络连接
     */
     static boolean isNetWorkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return networkInfo != null && networkInfo.isAvailable();
    }

    /**
     * 判断WIFI网络是否可用
     *
     * @msg 测试没用
     */
     static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        }
        return networkInfo != null && networkInfo.isAvailable();
    }

    /**
     * 判断MOBILE网络是否可用
     *
     * @msg 测试没用
     */
     static boolean isMobileConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        }
        return networkInfo != null && networkInfo.isAvailable();
    }

    /**
     * 获取当前网络连接的类型信息
     */
     static int getConnectedType(Context context) {
        int i = -1;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.isAvailable()) {
                i = networkInfo.getType();
//                int type = networkInfo.getType();
//                if (type == ConnectivityManager.TYPE_MOBILE) {
//                    JLog.d(networkInfo.getExtraInfo());
//                    if (networkInfo.getExtraInfo().toLowerCase() == "cmnet") {
//                        JLog.d("CMNET");
//                    } else {
//                        JLog.d("CMWAP");
//                    }
//                } else if (type == ConnectivityManager.TYPE_WIFI) {
//                    JLog.d("WIFI");
//                }
            }
        }
        return i;
    }

    /**
     * 获取当前ip地址
     *
     * @param context
     * @return
     */
     static String getLocalIpAddress(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext()
                    .getSystemService(Context.WIFI_SERVICE);
            @SuppressLint("MissingPermission")
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int i = wifiInfo.getIpAddress();
            return int2ip(i);
        } catch (Exception ex) {
            return " 获取IP出错!!!!请保证是WIFI,或者请重新打开网络!\n" + ex.getMessage();
        }
        // return null;
    }

    /**
     * 将ip的整数形式转换成ip形式
     *
     * @param ipInt
     * @return
     */
    private static String int2ip(int ipInt) {
        return String.valueOf(ipInt & 0xFF) + "." +
                ((ipInt >> 8) & 0xFF) + "." +
                ((ipInt >> 16) & 0xFF) + "." +
                ((ipInt >> 24) & 0xFF);
    }
}

package com.yjk.yjk.util;

import android.util.Log;

import com.yjk.yjk.BuildConfig;

public class YLog {

    private static String getTAG(){
        String TAG = "";
        try{
            Throwable stack = new Throwable().fillInStackTrace();
            StackTraceElement[] trace = stack.getStackTrace();

            if(trace != null) {
                String className = trace[0].getClassName();
                String methodName = trace[0].getMethodName();
                TAG = "[" + className + "] " + methodName;
            }else {
                TAG = "###YLOG";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return TAG;
    }

    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(getTAG(), msg);
        }
    }

    public static void e(Exception error) {
        if (BuildConfig.DEBUG) {
            Log.e(getTAG(), "Exception", error);
        }
    }

    public static void e(String error) {
        if (BuildConfig.DEBUG) {
            Log.e(getTAG(), error);
        }
    }

    public static void e(Exception exception, String error) {
        if (BuildConfig.DEBUG) {
            Log.e(getTAG(), error, exception);
        }
    }

}

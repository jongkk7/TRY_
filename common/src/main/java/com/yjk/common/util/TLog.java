package com.yjk.common.util;

import android.util.Log;

import com.yjk.common.BuildConfig;

public class TLog {

    private static String getTAG(){
        String TAG = "";
        try{
            Throwable stack = new Throwable().fillInStackTrace();
            StackTraceElement[] trace = stack.getStackTrace();

            if(trace != null) {
                String className = trace[2].getClassName();
                String methodName = trace[2].getMethodName();
                TAG = "[###" + className + "] " + methodName;
            }else {
                TAG = "###TLOG";
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

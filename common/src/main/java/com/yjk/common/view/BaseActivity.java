package com.yjk.common.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;

import com.yjk.common.util.TLog;
//test5
public abstract class BaseActivity  extends AppCompatActivity {
    protected final String TAG = "###" + getClass().getSimpleName();

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    protected abstract void initView();

    protected abstract void setEvent();

    // TODO : status bar 색상 변경
    protected void setStatusBarColor(boolean isWhiteIcon, int color) {
        try {
            Window window = getWindow();
            View view = window.getDecorView();

            if (isWhiteIcon) {
                new WindowInsetsControllerCompat(window, view).setAppearanceLightStatusBars(false);
            } else {
                new WindowInsetsControllerCompat(window, view).setAppearanceLightStatusBars(true);
            }

            window.setStatusBarColor(color);

        } catch (Exception e) {
            TLog.e("Exception -> " + e);
        }
    }
}

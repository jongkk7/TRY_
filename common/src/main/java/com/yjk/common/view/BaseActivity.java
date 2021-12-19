package com.yjk.common.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.viewpager.widget.ViewPager;

import com.yjk.common.util.TLog;

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    protected abstract void initView();

    protected abstract void setEvent();

    // TODO : 기본 팝업

    /**
     * Status bar & System bar
     * @param isWhiteIcon  : status bar의 icon 색상 ( white | black )
     * @param isFullScreen : status bar, system bar 제거
     * @param color        : status bar 색상
     */
    protected void setStatusBarColor(boolean isWhiteIcon, boolean isFullScreen, int color) {
        try {
            new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView()).setAppearanceLightStatusBars(!isWhiteIcon);
            getWindow().setStatusBarColor(color);
            if (isFullScreen) setFullScreen();
        } catch (Exception e) {
            TLog.d(e.getLocalizedMessage());
        }
    }

    /**
     * status bar 제거
     */
    protected void setTranslucentBar() {
        try {
            new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView()).hide(WindowInsetsCompat.Type.statusBars());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * status bar & system bar 제거
     */
    protected void setFullScreen() {
        setFullScreen(true, true);
    }

    protected void setFullScreen(boolean isHideStatusBar, boolean isHideSystemBar) {
        try {
            if (isHideStatusBar) {
                new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView()).hide(WindowInsetsCompat.Type.statusBars());
            } else {
                new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView()).show(WindowInsetsCompat.Type.statusBars());
            }

            if (isHideSystemBar) {
                new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView()).hide(WindowInsetsCompat.Type.systemBars());
            } else {
                new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView()).show(WindowInsetsCompat.Type.systemBars());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

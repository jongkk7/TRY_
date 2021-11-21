package com.yjk.yjk.util;

import android.graphics.Outline;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.annotation.RequiresApi;

/**
 * 그림자효과 커스터마이징 기능
 *
 * TODO - 좀 더 범용적으로 만들 필요있음
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class YhadowUtil extends ViewOutlineProvider {

    private final static int TOP = 0;
    private final static int LEFT = 0;
    private final static int DIFF_W = 0;
    private final static int DIFF_H = 10;
    private final static int RADIUS = 40;
    private final static float alpha = 0.6f;

    private int left;
    private int top;

    private int diffW;
    private int diffH;
    private int radius;

    public YhadowUtil(){
        this(TOP, LEFT, DIFF_W, DIFF_H, RADIUS);
    }

    public YhadowUtil(int radius) {
        this(TOP, LEFT, DIFF_W, DIFF_H, radius);
    }

    public YhadowUtil(int diffW, int diffH, int radius){
        this(TOP, diffW/2, diffW, diffH, radius);
    }

    public YhadowUtil(int left, int top, int diffW, int diffH, int radius) {
        this.left = left;
        this.top = top;
        this.diffW = diffW;
        this.diffH = diffH;
        this.radius = radius;
    }

    @Override
    public void getOutline(View view, Outline outline) {
//        Log.d("###CustomOutlineP", "w : " + view.getWidth() +", h : " + view.getHeight());
        outline.setRoundRect(left, top, view.getWidth() + diffW, view.getHeight() + diffH, radius);
        outline.setAlpha(alpha);
    }
}

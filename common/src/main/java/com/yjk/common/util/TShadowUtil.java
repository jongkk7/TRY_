package com.yjk.common.util;

import android.graphics.Outline;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TShadowUtil extends ViewOutlineProvider {

    private final static int TOP = 0;
    private final static int LEFT = 0;
    private final static int DIFF_W = 0;
    private final static int DIFF_H = 10;
    private final static int RADIUS = 40;
    private final static float ALPHA = 0.4f;

    private int left;
    private int top;

    private int diffW;
    private int diffH;
    private int radius;
    private float alpha;

    public TShadowUtil(){
        this(TOP, LEFT, DIFF_W, DIFF_H, RADIUS);
    }

    public TShadowUtil(int radius) {
        this(TOP, LEFT, DIFF_W, DIFF_H, radius);
    }

    public TShadowUtil(int diffW, int diffH, int radius){
        this(TOP, diffW/2, diffW, diffH, radius);
    }

    public TShadowUtil(int left, int top, int diffW, int diffH, int radius) {
        this.left = left;
        this.top = top;
        this.diffW = diffW;
        this.diffH = diffH;
        this.radius = radius;
    }

    public TShadowUtil(int left, int top, int diffW, int diffH, int radius, float alpha) {
        this.left = left;
        this.top = top;
        this.diffW = diffW;
        this.diffH = diffH;
        this.radius = radius;
        this.alpha = alpha;
    }

    @Override
    public void getOutline(View view, Outline outline) {
//        Log.d("###CustomOutlineP", "w : " + view.getWidth() +", h : " + view.getHeight());
        outline.setRoundRect(left, top, view.getWidth() + diffW, view.getHeight() + diffH, radius);
        outline.setAlpha(alpha);
    }
}

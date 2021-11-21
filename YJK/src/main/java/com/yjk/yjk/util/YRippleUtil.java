package com.yjk.yjk.util;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;

/**
 * 버튼이 눌려질때 원형으로 퍼지는 애니메이션 효과 적용하는 유틸
 * SDK >= 21
 *
 * 기본 사용법 : Builder(view).set();
 * 버튼 눌려지는 색 변경 : Builder(view).setColor("#66000000").set();
 */
public class YRippleUtil {

    public static class Builder{
        private String DEFAULT_COLOR = "#33000000";

        private YRippleUtil util;

        private View view; // 적용될 뷰
        private Drawable background; // 적용될 뷰의 백그라운드 ( 이 리소스에 리플효과를 더해줌 )
        private String color = DEFAULT_COLOR;

        public Builder(View view){
            util = new YRippleUtil();
            this.view = view;
            this.background = view.getBackground();
        }

        public Builder setColor(String color){
            this.color = color;
            return this;
        }

        public void set(){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setBackground(util.getBackgroundDrawable(Color.parseColor(color), background));
            }
        }

    }


    private RippleDrawable getBackgroundDrawable(int pressedColor, Drawable drawable){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // todo mask
            return new RippleDrawable(getPressedState(pressedColor), drawable, null);
        }
        return null;
    }

    private ColorStateList getPressedState(int pressedColor){
        return new ColorStateList(new int[][]{new int[]{}}, new int[]{pressedColor});
    }
}

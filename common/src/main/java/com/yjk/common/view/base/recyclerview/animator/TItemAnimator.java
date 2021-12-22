package com.yjk.common.view.base.recyclerview.animator;

import android.content.Context;

import androidx.recyclerview.widget.DefaultItemAnimator;

/**
 * 리싸이클러뷰 아이템 추가,삭제,변경 시 애니메이션 Util
 */
public class TItemAnimator {

    private static final long DURATION = 500L;
    private static long duration = DURATION;

    public static DefaultItemAnimator getDefaultAnimator(){
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(duration);
        animator.setRemoveDuration(duration);
        return animator;
    }

    public static SlideAnimator getSlideAnimator(Context context){
        SlideAnimator animator = new SlideAnimator(context);
        animator.setAddDuration(duration);
        animator.setRemoveDuration(duration);
        return animator;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}

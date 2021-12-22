package com.yjk.common.view.base.recyclerview.animator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.yjk.common.R;

public class SlideAnimator extends BaseAnimator{

    public SlideAnimator(Context context) {
        super(context);
    }

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        Animator animator = AnimatorInflater.loadAnimator(mContext, R.animator.remove_slide_left);
        animator.setTarget(holder.itemView);
        animator.start();

        return super.animateRemove(holder);
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        Animator animator = AnimatorInflater.loadAnimator(mContext, R.animator.add_slide_up);
//        animator.setInterpolator(new BounceInterpolator());
        animator.setTarget(holder.itemView);
        animator.start();
        return super.animateAdd(holder);
    }
}

package com.yjk.yjk.callback;

import android.os.SystemClock;
import android.view.View;

import com.yjk.yjk.util.YLog;

public class SingleClickListener implements View.OnClickListener {

    private long mLastClickTime = 0;

    private IOnClick callback;

    public SingleClickListener(IOnClick callback){
        this.callback = callback;
    }

    @Override
    public void onClick(View v) {
        try {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 100) {
                return;
            } else {
                mLastClickTime = SystemClock.elapsedRealtime();
                callback.onClick();
            }
        } catch (Exception e) {
            YLog.e(e);
        }
    }

    public interface IOnClick{
        void onClick();
    }

}

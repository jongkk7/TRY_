package com.yjk.common.callback;

import android.os.SystemClock;
import android.view.View;

import com.yjk.common.util.TLog;

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
            TLog.e(e);
        }
    }

    public interface IOnClick{
        void onClick();
    }

}

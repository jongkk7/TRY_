package com.yjk.common.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

    // TODO : 기본 팝업

}

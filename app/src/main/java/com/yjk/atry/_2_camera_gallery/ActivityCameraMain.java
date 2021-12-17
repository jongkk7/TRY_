package com.yjk.atry._2_camera_gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yjk.atry.R;
import com.yjk.atry._1_android_base.ActivityBaseMain;
import com.yjk.common.view.BaseActivity;

public class ActivityCameraMain extends BaseActivity {

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_start);

        initView();
        setEvent();
    }


    @Override
    protected void initView() {

        mContext = this;

    }

    @Override
    protected void setEvent() {

    }
}

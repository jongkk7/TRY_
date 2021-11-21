package com.yjk.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yjk.common.HashKeyUtil;
import com.yjk.yjk.view.ActivityIntro;

// test
public class ActivityStart extends AppCompatActivity {

    /**
     * FIXME !!
     * start activity
     */
    private Class activityClass = ActivityIntro.class;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        init();
        start();
    }

    private void start(){
        startActivity(new Intent(this, activityClass));
    }

    private void init(){

        context = this;

        if(BuildConfig.DEBUG){

            HashKeyUtil.getHashKey(context);

        }
    }
}

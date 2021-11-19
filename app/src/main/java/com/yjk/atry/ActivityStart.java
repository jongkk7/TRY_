package com.yjk.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.yjk.yjk.ActivityIntro;


public class ActivityStart extends AppCompatActivity {

    /**
     * FIXME !!
     * start activity
     */
    private Class activityClass = ActivityIntro.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        start();
    }

    private void start(){
        startActivity(new Intent(this, activityClass));
    }
}

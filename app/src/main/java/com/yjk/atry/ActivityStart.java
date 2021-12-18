package com.yjk.atry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dalvik.system.InMemoryDexClassLoader;

// test21
public class ActivityStart extends AppCompatActivity {
    public static final String KEY_NICKNAME = "nickname";

    private Context mContext;

    private EditText editTextNickname;
    private TextView textViewNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initView();
        setEvent();
    }


    private void initView() {

        mContext = this;

        editTextNickname = (EditText) findViewById(R.id.editTextNickname);
        textViewNext = (TextView) findViewById(R.id.textViewNext);
    }

    private void setEvent(){

        textViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nickname = editTextNickname.getText().toString();
                if(nickname.isEmpty()){
                    Toast.makeText(mContext, "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 다음화면
                Intent i = new Intent(mContext, ActivityMain.class);
                i.putExtra(KEY_NICKNAME, nickname);
                startActivity(i);

            }
        });
    }
}

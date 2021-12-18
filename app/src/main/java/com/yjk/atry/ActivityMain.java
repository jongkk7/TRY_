package com.yjk.atry;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yjk.yjk.util.YTextUtil;

// test
public class ActivityMain extends AppCompatActivity {

    private Context mContext;

    private String nickname;

    private TextView textViewModify;
    private TextView textViewWelcome;
    private LinearLayout linearLayoutMain;
    private LinearLayout linearLAyoutModify;
    private ImageView imageViewBack;
    private EditText editTextNickname;
    private TextView textViewOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();

        initView();
        setEvent();
    }

    private void getData() {

        Intent i = getIntent();
        nickname = i.getStringExtra(ActivityStart.KEY_NICKNAME);

    }


    private void initView() {

        mContext = this;

        textViewModify = (TextView) findViewById(R.id.textViewModify);
        textViewWelcome = (TextView) findViewById(R.id.textViewWelcome);
        linearLayoutMain = (LinearLayout) findViewById(R.id.linearLayoutMain);
        linearLAyoutModify = (LinearLayout) findViewById(R.id.linearLAyoutModify);
        imageViewBack = (ImageView) findViewById(R.id.imageViewBack);
        editTextNickname = (EditText) findViewById(R.id.editTextNickname);
        textViewOk = (TextView) findViewById(R.id.textViewOk);

        setNicknameText();
    }

    private void setEvent() {

        // 수정하기
        textViewModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayoutMain.setVisibility(View.GONE);
                linearLAyoutModify.setVisibility(View.VISIBLE);

            }
        });

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayoutMain.setVisibility(View.VISIBLE);
                linearLAyoutModify.setVisibility(View.GONE);
            }
        });

        textViewOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nickname = editTextNickname.getText().toString();
                if(nickname.isEmpty()){
                    Toast.makeText(mContext, "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                setNicknameText();
                imageViewBack.performClick();
            }
        });
    }

    private void setNicknameText(){
        textViewWelcome.setText(nickname + "님,\n" + "반갑습니다.");
        YTextUtil.convertSpecificText(textViewWelcome, Color.BLACK, true, nickname,"님,");
    }
}

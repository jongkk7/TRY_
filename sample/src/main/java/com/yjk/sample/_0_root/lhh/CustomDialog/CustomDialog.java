package com.yjk.sample._0_root.lhh.CustomDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yjk.sample.R;

//import com.yjk.atry.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private EditText et_title,et_contents;
    private Button bt_positive,bt_negative;
    private Context mContext;
    private CustomDialogListener customDialogListener;

    public CustomDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public interface CustomDialogListener {
        void onPositiveClicked(String title, String contents);
        void onNegativeClicked();
    }

    public void setDialogListener(CustomDialogListener customDialogListener) {
        this.customDialogListener = customDialogListener;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        bt_positive = findViewById(R.id.bt_positive);
        bt_negative = findViewById(R.id.bt_negative);
        et_title = findViewById(R.id.et_title);
        et_contents = findViewById(R.id.et_contents);

        bt_positive.setOnClickListener(this);
        bt_negative.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.bt_positive:
//                String title = et_title.getText().toString();
//                String contents = et_contents.getText().toString();
//
//                if(title.trim().equals("")  || contents.trim().equals("")){
//                    Toast.makeText(mContext,"title과 contents를 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
//                } else {
//                    customDialogListener.onPositiveClicked(title, contents);
//                }
//                dismiss();
//                break;
//
//            case R.id.bt_negative:
//                cancel();
//                break;
//
//        }

    }
}

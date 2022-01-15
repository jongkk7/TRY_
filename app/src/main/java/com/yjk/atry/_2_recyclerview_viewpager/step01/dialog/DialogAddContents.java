package com.yjk.atry._2_recyclerview_viewpager.step01.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.yjk.atry.R;
import com.yjk.atry._2_recyclerview_viewpager.step01.datamodel.SimpleContentsDataModel;
import com.yjk.common.callback.ResponseCallback;
import com.yjk.common.callback.SingleClickListener;
import com.yjk.common.util.TTextUtil;
import com.yjk.common.view.dialog.DialogCommon;

public class DialogAddContents extends DialogCommon {

    private ResponseCallback<SimpleContentsDataModel> mCallback;

    private LinearLayout root;
    private EditText editTextTitle;
    private EditText editTextContents;
    private RelativeLayout relativeLayoutCancel;
    private RelativeLayout relativeLayoutConfirm;

    public DialogAddContents(@NonNull Context context, ResponseCallback<SimpleContentsDataModel> callback) {
        super(context);
        this.mCallback = callback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_stage2_step1_add);

        setWindow();
        initView();
        setEvent();

    }

    @Override
    protected void initView() {

        root = (LinearLayout) findViewById(R.id.root);
        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextContents = (EditText) findViewById(R.id.editTextContents);
        relativeLayoutCancel = (RelativeLayout) findViewById(R.id.relativeLayoutCancel);
        relativeLayoutConfirm = (RelativeLayout) findViewById(R.id.relativeLayoutConfirm);
    }

    @Override
    protected void setEvent() {

        // 확인버튼
        relativeLayoutConfirm.setOnClickListener(new SingleClickListener(new SingleClickListener.IOnClick() {
            @Override
            public void onClick() {

                String title = editTextTitle.getText().toString();
                String contents = editTextContents.getText().toString();

                if(TTextUtil.isNotEmpty(title) && TTextUtil.isNotEmpty(contents)) {
                    mCallback.onResponse(new SimpleContentsDataModel(title, contents));
                    dismiss();
                }else {
                    Toast.makeText(getContext(), "값을 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        }));

        // 취소버튼
        relativeLayoutCancel.setOnClickListener(new SingleClickListener(new SingleClickListener.IOnClick() {
            @Override
            public void onClick() {
                dismiss();
            }
        }));
    }

}

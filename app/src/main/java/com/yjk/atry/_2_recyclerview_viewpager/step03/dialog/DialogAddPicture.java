package com.yjk.atry._2_recyclerview_viewpager.step03.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.yjk.atry.R;
import com.yjk.common.view.dialog.DialogCommon;

public class DialogAddPicture extends DialogCommon {

    private IPictureAddCallback mCallback;
    private LinearLayout root;
    private RelativeLayout relativeLayoutCancel;
    private RelativeLayout relativeLayoutCamera;
    private RelativeLayout relativeLayoutAlbum;

    public DialogAddPicture(@NonNull Context context, IPictureAddCallback callback) {
        super(context);
        this.mCallback = callback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_stage2_step3_add);

        setWindow();
        initView();
        setEvent();

    }

    @Override
    protected void initView() {

        root = (LinearLayout) findViewById(R.id.root);
        relativeLayoutCancel = (RelativeLayout) findViewById(R.id.relativeLayoutCancel);
        relativeLayoutCamera = (RelativeLayout) findViewById(R.id.relativeLayoutCamera);
        relativeLayoutAlbum = (RelativeLayout) findViewById(R.id.relativeLayoutAlbum);
    }

    @Override
    protected void setEvent() {

        relativeLayoutCancel.setOnClickListener(v -> {
            dismiss();
        });

        relativeLayoutCamera.setOnClickListener(v -> {
            mCallback.onCamera();
            dismiss();
        });

        relativeLayoutAlbum.setOnClickListener(v -> {
            mCallback.onAlbum();
            dismiss();
        });
    }

    public interface IPictureAddCallback {
        void onCamera();

        void onAlbum();
    }
}

package com.yjk.common.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;
import androidx.annotation.NonNull;

public abstract class DialogCommon extends Dialog {

    public DialogCommon(@NonNull Context context) {
        super(context);
    }

    protected abstract void initView();

    protected abstract void setEvent();

    protected void setWindow() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(getWindow().getAttributes());
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.dimAmount = 0.5f;
        getWindow().setAttributes(params);
    }
}

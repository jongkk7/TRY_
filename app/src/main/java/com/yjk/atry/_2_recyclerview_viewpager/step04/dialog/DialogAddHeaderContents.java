package com.yjk.atry._2_recyclerview_viewpager.step04.dialog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.yjk.atry.R;
import com.yjk.atry._2_recyclerview_viewpager.step04.datamodel.HeaderDataModel;
import com.yjk.common.callback.ResponseCallback;
import com.yjk.common.callback.SingleClickListener;
import com.yjk.common.util.TDateUtil;
import com.yjk.common.util.TTextUtil;
import com.yjk.common.view.dialog.DialogCommon;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DialogAddHeaderContents extends DialogCommon {

    private ResponseCallback<HeaderDataModel> mCallback;
    private LinearLayout root;
    private TextView textViewDate;
    private EditText editTextContents;
    private RelativeLayout relativeLayoutConfirm;


    public DialogAddHeaderContents(@NonNull Context context, ResponseCallback<HeaderDataModel> callback) {
        super(context);
        this.mCallback = callback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_stage2_add_header_contents);

        setWindow();
        initView();
        setEvent();

    }

    @Override
    protected void initView() {
        root = (LinearLayout) findViewById(R.id.root);
        textViewDate = (TextView) findViewById(R.id.textViewDate);
        editTextContents = (EditText) findViewById(R.id.editTextContents);
        relativeLayoutConfirm = (RelativeLayout) findViewById(R.id.relativeLayoutConfirm);
    }

    @Override
    protected void setEvent() {

        // 확인버튼
        relativeLayoutConfirm.setOnClickListener(new SingleClickListener(new SingleClickListener.IOnClick() {
            @Override
            public void onClick() {

                String date = textViewDate.getText().toString();
                String contents = editTextContents.getText().toString();

                if (TTextUtil.isNotEmpty(date) && TTextUtil.isNotEmpty(contents)) {
                    mCallback.onResponse(new HeaderDataModel(date, contents));
                    dismiss();
                } else {
                    Toast.makeText(getContext(), "값을 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        }));

        // 달력
        textViewDate.setOnClickListener(new SingleClickListener(new SingleClickListener.IOnClick() {
            @Override
            public void onClick() {
                Calendar c = Calendar.getInstance();
                new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 날짜 선택 후 처리
                        c.set(year, month, dayOfMonth);
                        String dateStr = TDateUtil.parseDate(c.getTime(), TDateUtil.dateFormatDot);
                        textViewDate.setText(dateStr);
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
            }
        }));
    }

}

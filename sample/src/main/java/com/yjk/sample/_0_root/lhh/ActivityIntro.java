package com.yjk.sample._0_root.lhh;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.common.view.base.BaseActivity;
import com.yjk.sample.R;
import com.yjk.sample._0_root.lhh.CustomDialog.CustomDialog;
import com.yjk.sample._0_root.lhh.adapter.AdapterActivity;
import com.yjk.sample._0_root.lhh.datamodel.DataActivity;

import java.util.ArrayList;

public class ActivityIntro extends BaseActivity implements View.OnClickListener{
    private ArrayList<DataActivity> dList;
    private AdapterActivity adapter;
    private RecyclerView recyclerView;
    private Context mContext;
    private TextView plusButton, tv_title,tv_contents;
    private View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycerview);

        initView();
        setEvent();

    }

    @Override
    protected void initView() {
        tv_title = findViewById(R.id.tv_title);
        tv_contents = findViewById(R.id.tv_contents);
        plusButton = findViewById(R.id.plusButton);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview1);

        dList = new ArrayList<>();
        adapter = new AdapterActivity(mContext,dList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        plusButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.plusButton:
//                CustomDialog dlg = new CustomDialog(ActivityIntro.this);
//
//                dlg.setDialogListener(new CustomDialog.CustomDialogListener(){
//                    @Override
//                    public void onPositiveClicked(String title, String contents) {
//
//                        DataActivity data = new DataActivity(title, contents);
//
//                        dList.add(0,data);
//                        adapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onNegativeClicked() {
//
//                    }
//                });
//                dlg.show();
//
//                break;
//
//        }




    }


    @Override
    protected void setEvent() {
        adapter.setOnItemDeleteListener(new AdapterActivity.OnItemDeleteListener() {
            @Override
            public void onItemDelete(View view, final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityIntro.this);
                builder.setTitle("삭제").setMessage(dList.get(position).getTitle() + "을(를) 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dList.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNeutralButton("취소", null)
                        .show();
            }
        });






    }


}

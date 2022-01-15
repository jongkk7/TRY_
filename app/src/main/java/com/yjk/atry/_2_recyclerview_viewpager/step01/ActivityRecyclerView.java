package com.yjk.atry._2_recyclerview_viewpager.step01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.atry.R;
import com.yjk.atry._2_recyclerview_viewpager.step01.adapter.AdapterSimpleContents;
import com.yjk.atry._2_recyclerview_viewpager.step01.datamodel.SimpleContentsDataModel;
import com.yjk.atry._2_recyclerview_viewpager.step01.dialog.DialogAddContents;
import com.yjk.common.callback.ResponseCallback;
import com.yjk.common.callback.SingleClickListener;
import com.yjk.common.view.base.BaseActivity;

import java.util.ArrayList;

/**
 * 도전과제 1
 */
public class ActivityRecyclerView extends BaseActivity {

    private Activity mActivity;

    private AdapterSimpleContents adapter;

    private RelativeLayout relativeLayoutAdd;
    private RecyclerView recyclerViewContentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2_step1_main);

        initView();
        setEvent();

        initList();
    }


    @Override
    protected void initView() {
        mActivity = this;

        relativeLayoutAdd = (RelativeLayout) findViewById(R.id.relativeLayoutAdd);
        recyclerViewContentsList = (RecyclerView) findViewById(R.id.recyclerViewContentsList);
    }

    @Override
    protected void setEvent() {

        relativeLayoutAdd.setOnClickListener(new SingleClickListener(new SingleClickListener.IOnClick() {
            @Override
            public void onClick() {
                new DialogAddContents(mContext, new ResponseCallback<SimpleContentsDataModel>() {
                    @Override
                    public void onResponse(SimpleContentsDataModel data) {
                        // item 추가
                        adapter.addItem(data);
                    }

                    @Override
                    public void onFailed(String fault) {
                        // do nothing..
                    }
                }).show();
            }
        }));

    }

    private void initList(){

        recyclerViewContentsList.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new AdapterSimpleContents(mContext, new ArrayList<SimpleContentsDataModel>());
        recyclerViewContentsList.setAdapter(adapter);

    }

}

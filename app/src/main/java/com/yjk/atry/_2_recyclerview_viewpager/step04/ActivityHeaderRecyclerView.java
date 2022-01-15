package com.yjk.atry._2_recyclerview_viewpager.step04;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.atry.R;
import com.yjk.atry._2_recyclerview_viewpager.step04.adapter.AdapterHeader;
import com.yjk.atry._2_recyclerview_viewpager.step04.datamodel.HeaderDataModel;
import com.yjk.atry._2_recyclerview_viewpager.step04.dialog.DialogAddHeaderContents;
import com.yjk.common.callback.ResponseCallback;
import com.yjk.common.callback.SingleClickListener;
import com.yjk.common.view.base.BaseActivity;

import java.util.ArrayList;

/**
 * 도전과제 4
 */
public class ActivityHeaderRecyclerView extends BaseActivity {

    private AdapterHeader adapter;

    private RelativeLayout relativeLayoutAdd;
    private RecyclerView recyclerViewContentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2_step4_main);

        initView();
        setEvent();

        initList();
    }


    @Override
    protected void initView() {

        relativeLayoutAdd = (RelativeLayout) findViewById(R.id.relativeLayoutAdd);
        recyclerViewContentsList = (RecyclerView) findViewById(R.id.recyclerViewContentsList);
    }

    @Override
    protected void setEvent() {

        relativeLayoutAdd.setOnClickListener(new SingleClickListener(new SingleClickListener.IOnClick() {
            @Override
            public void onClick() {
                new DialogAddHeaderContents(mContext, new ResponseCallback<HeaderDataModel>() {
                    @Override
                    public void onResponse(HeaderDataModel res) {
                        adapter.addItem(res);
                    }

                    @Override
                    public void onFailed(String fault) {
                        // error 처리
                    }
                }).show();

            }
        }));

    }

    private void initList() {

        recyclerViewContentsList.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new AdapterHeader(mContext, new ArrayList<>(), result -> {
            // 해당 아이템 클릭

        });
        recyclerViewContentsList.setAdapter(adapter);

    }

}

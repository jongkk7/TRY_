package com.yjk.atry._0_root;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.atry.R;
import com.yjk.atry._0_root.adapter.AdapterProjectList;
import com.yjk.atry._0_root.datamodel.ProjectDataModel;
import com.yjk.atry._0_root.presenter.IntroPresenter;
import com.yjk.common.callback.SingleCallback;
import com.yjk.common.view.base.BaseActivity;
import com.yjk.common.view.base.recyclerview.TRecyclerViewItemAnimator;

import java.util.ArrayList;

// Intro
public class ActivityIntro extends BaseActivity {

    private IntroPresenter presenter;
    private AdapterProjectList adapterProjectList;
    private LinearLayout root;
    private RecyclerView recyclerViewProjectList;

    private boolean isAnimation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage0_intro);

        initView();
        setEvent();

        getProjectList();
    }


    @Override
    protected void initView() {

        setStatusBarColor(false, false, Color.parseColor("#fafafa"));
        presenter = new IntroPresenter();

        root = (LinearLayout) findViewById(R.id.root);
        recyclerViewProjectList = (RecyclerView) findViewById(R.id.recyclerViewProjectList);
        recyclerViewProjectList.setLayoutManager(new LinearLayoutManager(mContext)); // <- 필수 !
    }

    @Override
    protected void setEvent() {

    }

    private void getProjectList() {

        adapterProjectList = new AdapterProjectList(mContext, new ArrayList<>(), new SingleCallback<ProjectDataModel>() {
            @Override
            public void onResult(ProjectDataModel result) {
                // 아이템 클릭 -> 해당 프로젝트로 이동
                startActivity(new Intent(mContext, result.getClassInfo()));
            }
        });

        recyclerViewProjectList.setAdapter(adapterProjectList);
        recyclerViewProjectList.setItemAnimator(TRecyclerViewItemAnimator.getSlideAnimator(mContext));

        if(isAnimation) {
            int delay = 200;
            for (ProjectDataModel data : presenter.getProjectList()) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapterProjectList.addItem(data);
                    }
                }, delay);
                delay = delay + 150;
            }
        }else {
            adapterProjectList.addItem(presenter.getProjectList());
        }
    }
}

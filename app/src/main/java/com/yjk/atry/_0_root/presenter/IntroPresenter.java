package com.yjk.atry._0_root.presenter;

import com.yjk.atry._0_root.datamodel.ProjectDataModel;
import com.yjk.atry._1_android_base.ActivityBaseStart;
import com.yjk.atry._2_recyclerview_viewpager.step01.ActivityRecyclerView;

import java.util.ArrayList;

public class IntroPresenter {

    /**
     * 프로젝트 리스트 반환 함수
     */
    public ArrayList<ProjectDataModel> getProjectList(){

        ArrayList<ProjectDataModel> list = new ArrayList<>();

        // 프로젝트 추가
        list.add(new ProjectDataModel(1,"Android 기초편", ActivityBaseStart.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager", ActivityRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager", ActivityRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager", ActivityRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager", ActivityRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager", ActivityRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager", ActivityRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager", ActivityRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager", ActivityRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager", ActivityRecyclerView.class));

        // todo 새로운 프로젝트 시작시 추가


        return list;
    }

}

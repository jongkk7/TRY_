package com.yjk.atry._0_root.presenter;

import com.yjk.atry._0_root.datamodel.ProjectDataModel;
import com.yjk.atry._101_room.ActivityRoom;
import com.yjk.atry._3_youtube.ActivityYoutube;
import com.yjk.atry._1_android_base.ActivityBaseStart;
import com.yjk.atry._2_recyclerview_viewpager.step01.ActivityRecyclerView;
import com.yjk.atry._2_recyclerview_viewpager.step02.ActivityViewPager;
import com.yjk.atry._2_recyclerview_viewpager.step03.ActivityViewPagerAndRecyclerView;
import com.yjk.atry._2_recyclerview_viewpager.step04.ActivityHeaderRecyclerView;

import java.util.ArrayList;

public class IntroPresenter {

    /**
     * 프로젝트 리스트 반환 함수
     */
    public ArrayList<ProjectDataModel> getProjectList(){

        ArrayList<ProjectDataModel> list = new ArrayList<>();

        // 프로젝트 추가
        list.add(new ProjectDataModel(1,"Android 기초편", ActivityBaseStart.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager (1)", ActivityRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager (2)", ActivityViewPager.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager (3)", ActivityViewPagerAndRecyclerView.class));
        list.add(new ProjectDataModel(2,"RecyclerView & ViewPager (4)", ActivityHeaderRecyclerView.class));
        list.add(new ProjectDataModel(3,"YouTube", ActivityYoutube.class));
        list.add(new ProjectDataModel(101,"Room ( DB )", ActivityRoom.class));

        // todo 새로운 프로젝트 시작시 추가


        return list;
    }

}

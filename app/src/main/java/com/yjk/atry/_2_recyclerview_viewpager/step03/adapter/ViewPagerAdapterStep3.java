package com.yjk.atry._2_recyclerview_viewpager.step03.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.yjk.atry._2_recyclerview_viewpager.step03.datamodel.PictureDataModel;
import com.yjk.atry._2_recyclerview_viewpager.step03.fragment.FragmentPicture;
import com.yjk.common.callback.SingleCallback;

import java.util.ArrayList;

public class ViewPagerAdapterStep3 extends FragmentStateAdapter {

    private ArrayList<FragmentPicture> mList;

    public ViewPagerAdapterStep3(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

        mList = new ArrayList<>();

        AdapterStep3.IPictureItemCallback callback = new AdapterStep3.IPictureItemCallback() {
            @Override
            public void onLike(PictureDataModel data) {
                mList.get(1).addItem(data);
            }

            @Override
            public void onDelete(PictureDataModel data) {
                for(FragmentPicture fragmentPicture : mList){
                    fragmentPicture.deleteItem(data);
                }
            }
        };

        mList.add(new FragmentPicture(FragmentPicture.VIEW_TYPE_DETAIL, callback));
        mList.add(new FragmentPicture(FragmentPicture.VIEW_TYPE_GALLERY, callback));
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mList.get(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(PictureDataModel data) {
        for(FragmentPicture fragmentPicture : mList){
            fragmentPicture.addItem(data);
        }
    }

    public int getTotalCount() {
        return mList.get(0).getCount();
    }
}

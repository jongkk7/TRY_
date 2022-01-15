package com.yjk.atry._2_recyclerview_viewpager.step03.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.atry.R;
import com.yjk.atry._2_recyclerview_viewpager.step03.adapter.AdapterStep3;
import com.yjk.atry._2_recyclerview_viewpager.step03.datamodel.PictureDataModel;
import com.yjk.common.callback.SingleCallback;
import com.yjk.common.util.TLog;

import java.util.ArrayList;

public class FragmentPicture extends Fragment {
    public static final int VIEW_TYPE_DETAIL = 0;
    public static final int VIEW_TYPE_GALLERY = 1;

    private int viewType = 0;
    private AdapterStep3.IPictureItemCallback mCallback;

    private AdapterStep3 adapterStep3;

    private RecyclerView recyclerViewPictureList;

    public FragmentPicture(int type, AdapterStep3.IPictureItemCallback callback) {
        this.mCallback = callback;
        this.viewType = type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stage2_step4_picture, parent, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerViewPictureList = (RecyclerView) view.findViewById(R.id.recyclerViewPictureList);

        if (viewType == VIEW_TYPE_DETAIL) {
            recyclerViewPictureList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        } else {
            recyclerViewPictureList.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
        adapterStep3 = new AdapterStep3(viewType, getContext(), new AdapterStep3.IPictureItemCallback() {
            @Override
            public void onLike(PictureDataModel data) {
                mCallback.onLike(data);
            }

            @Override
            public void onDelete(PictureDataModel data) {
                mCallback.onDelete(data);
            }
        });
        recyclerViewPictureList.setAdapter(adapterStep3);
    }

    public void addItem(PictureDataModel data) {
        adapterStep3.addItem(data);
    }

    public void deleteItem(PictureDataModel data) {
        adapterStep3.removeItem(data);
    }

    public int getCount() {
        return adapterStep3.getItemCount();
    }

}











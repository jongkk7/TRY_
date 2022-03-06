package com.yjk.common.view.base.recyclerview;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.yjk.common.callback.SingleCallback;

import java.util.ArrayList;

public abstract class BaseRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context mContext;
    protected ArrayList<T> mList;

    protected SingleCallback<T> mCallback;

    public BaseRecyclerViewAdapter(Context context, ArrayList<T> list){
        this(context, list, null);
    }

    public BaseRecyclerViewAdapter(Context context, ArrayList<T> list, SingleCallback<T> callback){
        this.mContext = context;
        this.mList = list;
        this.mCallback = callback;
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void addItem(T item){
        mList.add(item);
        notifyItemInserted(mList.size()-1);
    }

    public void addItem(ArrayList<T> list){
        mList.addAll(list);
        notifyItemRangeInserted(mList.size() - list.size(), list.size());
    }

    public void removeItem(T item){
        int pos = mList.indexOf(item);
        if(pos > 0){
            mList.remove(pos);
        }
        notifyItemRemoved(pos);
    }

    public void removeItem(ArrayList<T> list){
        for(T item : list) {
            removeItem(item);
        }
    }

    public void updateItem(T item){
        int pos = mList.indexOf(item);
        if(pos > 0){
            notifyItemChanged(pos);
        }
    }

    public void updateItem(ArrayList<T> list){
        for(T item : list){
            updateItem(item);
        }
    }
}

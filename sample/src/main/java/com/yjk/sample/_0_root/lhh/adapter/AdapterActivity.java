package com.yjk.sample._0_root.lhh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.sample.R;
import com.yjk.sample._0_root.lhh.datamodel.DataActivity;

import java.util.ArrayList;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ViewHolder> {
    private ArrayList<DataActivity> mList;
    private Context mContext;


    public interface OnItemDeleteListener {
        void onItemDelete(View view, int position);
    }
    private OnItemDeleteListener deleteListener = null;

    public void setOnItemDeleteListener(OnItemDeleteListener listener){
        this.deleteListener = listener;
    }

    public AdapterActivity(Context context, ArrayList<DataActivity> list) {
        this.mContext = context;
        this.mList = list;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycelerview_items, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataActivity data = mList.get(position);

        try {
            holder.tv_title.setText(data.getTitle());
            holder.tv_contents.setText(data.getContents());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title, tv_contents;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tv_title = itemView.findViewById(R.id.tv_title);
            this.tv_contents = itemView.findViewById(R.id.tv_contents);


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        if(deleteListener !=null){
                            deleteListener.onItemDelete(view,position);
                        }

                    }
                    return false;
                }
            });

        }
    }

    interface OnItemDelete {
        void onDeleteClick(View view, int position);
    }
}



package com.yjk.atry._2_recyclerview_viewpager.step01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.atry.R;
import com.yjk.atry._2_recyclerview_viewpager.step01.datamodel.SimpleContentsDataModel;
import com.yjk.common.util.TLog;

import java.util.ArrayList;

public class AdapterSimpleContents extends RecyclerView.Adapter<AdapterSimpleContents.SimpleContentsViewHolder> {

    private Context mContext;

    private ArrayList<SimpleContentsDataModel> mList;

    public AdapterSimpleContents(Context context, ArrayList<SimpleContentsDataModel> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public SimpleContentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.adapter_stage2_step1_item, parent, false);
        return new SimpleContentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleContentsViewHolder holder, int position) {

        SimpleContentsDataModel item = mList.get(position);

        try {

            holder.textViewTitle.setText(item.getTitle());

            holder.textViewContents.setText(item.getContents());

        } catch (Exception e) {
            TLog.e("Exception -> " + e);
        }
    }

    public void addItem(SimpleContentsDataModel data){
        mList.add(data);
        notifyItemInserted(mList.size());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class SimpleContentsViewHolder extends RecyclerView.ViewHolder {

        private CardView root;
        private TextView textViewTitle;
        private TextView textViewContents;

        public SimpleContentsViewHolder(@NonNull View itemView) {
            super(itemView);

            root = (CardView) itemView.findViewById(R.id.root);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewContents = (TextView) itemView.findViewById(R.id.textViewContents);

            // 롱클릭 - 삭제
            root.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return false;
                }
            });
        }
    }
}

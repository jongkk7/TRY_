package com.yjk.atry._0_root.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.atry.R;
import com.yjk.atry._0_root.datamodel.ProjectDataModel;
import com.yjk.common.callback.SingleCallback;
import com.yjk.common.callback.SingleClickListener;
import com.yjk.common.util.TLog;
import com.yjk.common.util.TShadowUtil;

import java.util.ArrayList;

public class AdapterProjectList extends RecyclerView.Adapter<AdapterProjectList.ProjectViewHolder> {

    private Context mContext;
    private ArrayList<ProjectDataModel> mList;
    private SingleCallback<ProjectDataModel> mCallback;

    public AdapterProjectList(Context context, ArrayList<ProjectDataModel> list, SingleCallback<ProjectDataModel> callback) {
        this.mContext = context;
        this.mList = list;
        this.mCallback = callback;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.adapter_stage0_project_item, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {

        ProjectDataModel item = mList.get(position);

        try {

            holder.textViewStage.setText(item.getStage() + " stage");

            holder.textViewTitle.setText(item.getTitle());

        } catch (Exception e) {
            TLog.e("Exception -> " + e);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout root;
        private TextView textViewStage;
        private TextView textViewTitle;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            root = (RelativeLayout) itemView.findViewById(R.id.root);
            textViewStage = (TextView) itemView.findViewById(R.id.textViewStage);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);

            root.setOutlineProvider(new TShadowUtil(-2, 0, 5, 8, 15, 0.2f));

            root.setOnClickListener(new SingleClickListener(new SingleClickListener.IOnClick() {
                @Override
                public void onClick() {
                    mCallback.onResult(mList.get(getAdapterPosition()));
                }
            }));
        }
    }
}

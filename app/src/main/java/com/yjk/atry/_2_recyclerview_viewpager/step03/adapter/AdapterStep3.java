package com.yjk.atry._2_recyclerview_viewpager.step03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.atry.R;
import com.yjk.atry._2_recyclerview_viewpager.step03.datamodel.PictureDataModel;
import com.yjk.atry._2_recyclerview_viewpager.step03.fragment.FragmentPicture;
import com.yjk.common.callback.SingleCallback;
import com.yjk.common.callback.SingleClickListener;
import com.yjk.common.util.TLog;

import java.util.ArrayList;

public class AdapterStep3 extends RecyclerView.Adapter<AdapterStep3.PictureViewHolder> {

    private Context mContext;

    private int viewType = FragmentPicture.VIEW_TYPE_DETAIL;
    private ArrayList<PictureDataModel> mList;
    private IPictureItemCallback mCallback;

    public AdapterStep3(int viewType, Context context, IPictureItemCallback callback) {
        this.viewType = viewType;
        this.mContext = context;
        this.mList = new ArrayList<>();
        this.mCallback = callback;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.adapter_stage2_step3_item, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {

        PictureDataModel item = mList.get(position);

        try {

            holder.textViewTitle.setText(item.getTitle());

            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.imageViewPicture.getLayoutParams();
            if(viewType == FragmentPicture.VIEW_TYPE_DETAIL) {
                params.height = item.getBitmap().getHeight();
            }else {
                params.height = 300;
            }
            holder.imageViewPicture.setLayoutParams(params);
            holder.imageViewPicture.setImageBitmap(item.getBitmap());

            holder.relativeLayoutBottomLayer.setVisibility(viewType == FragmentPicture.VIEW_TYPE_DETAIL ? View.VISIBLE : View.GONE);

            holder.relativeLayoutLike.setSelected(item.isLike());
        } catch (Exception e) {
            TLog.e("Exception -> " + e);
        }
    }

    public void addItem(PictureDataModel data) {
        if(viewType == FragmentPicture.VIEW_TYPE_DETAIL) {
            mList.add(data);
            notifyItemInserted(mList.size());
        }else {
            if(data.isLike()){
                mList.add(data);
                notifyItemInserted(mList.size());
            }else {
                removeItem(data);
            }
        }
    }

    public void removeItem(PictureDataModel data){
        int pos = mList.indexOf(data);
        if(pos >= 0){
            mList.remove(pos);
            notifyItemRemoved(pos);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class PictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewPicture;
        private TextView textViewTitle;
        private RelativeLayout relativeLayoutLike;
        private RelativeLayout relativeLayoutBottomLayer;
        private LinearLayout root;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewPicture = (ImageView) itemView.findViewById(R.id.imageViewPicture);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            relativeLayoutLike = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutLike);
            relativeLayoutBottomLayer = (RelativeLayout) itemView.findViewById(R.id.relativeLayoutBottomLayer);
            root = (LinearLayout) itemView.findViewById(R.id.root);

            // 좋아요
            relativeLayoutLike.setOnClickListener(new SingleClickListener(() -> {
                PictureDataModel data = mList.get(getAdapterPosition());
                data.setLike(!data.isLike());
                mCallback.onLike(data);
                notifyItemChanged(getAdapterPosition());
            }));

            // 삭제
            root.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    PictureDataModel data = mList.get(getAdapterPosition());
                    if(viewType == FragmentPicture.VIEW_TYPE_DETAIL) {
                        mCallback.onDelete(data);
                    }
                    return true;
                }
            });
        }
    }

    public interface IPictureItemCallback{
        void onLike(PictureDataModel data);
        void onDelete(PictureDataModel data);
    }
}

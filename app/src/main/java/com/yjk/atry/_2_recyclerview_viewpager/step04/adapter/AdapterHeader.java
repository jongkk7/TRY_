package com.yjk.atry._2_recyclerview_viewpager.step04.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.yjk.atry.R;
import com.yjk.atry._2_recyclerview_viewpager.step04.datamodel.HeaderDataModel;
import com.yjk.common.callback.SingleCallback;
import com.yjk.common.util.TDateUtil;
import com.yjk.common.util.TLog;
import com.yjk.common.view.base.recyclerview.BaseRecyclerViewAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class AdapterHeader extends BaseRecyclerViewAdapter<HeaderDataModel, AdapterHeader.HeaderContentsViewHolder> {

    public AdapterHeader(Context context, ArrayList<HeaderDataModel> list, SingleCallback<HeaderDataModel> callback) {
        super(context, list, callback);
    }

    @NonNull
    @Override
    public HeaderContentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.adapter_stage2_header_contents_item, parent, false);
        return new HeaderContentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeaderContentsViewHolder holder, int position) {

        HeaderDataModel item = mList.get(position);

        try {

            // date
            String date = TDateUtil.parseDate(item.getDate(), TDateUtil.dateFormatDot, TDateUtil.dateFormatYearMonthWithDot);
            String day = TDateUtil.parseDate(item.getDate(), TDateUtil.dateFormatDot, new SimpleDateFormat("(dd일)"));
            holder.textViewDate.setText(date);
            holder.textViewDay.setText(day);

            boolean isTop; // header가 나오는지 여부
            if (position != 0) {
                String beforeDate = TDateUtil.parseDate(mList.get(position - 1).getDate(), TDateUtil.dateFormatDot, TDateUtil.dateFormatYearMonthWithDot);
                isTop = !date.equals(beforeDate);
            } else {
                isTop = true;
            }

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.root.getLayoutParams();
            if(isTop){// 전 데이터와 같은 년/월 일 경우 or 첫번째 데이터
                holder.linearLayoutDateLayer.setVisibility(View.VISIBLE);
                params.topMargin = 30;
            }else {
                holder.linearLayoutDateLayer.setVisibility(View.GONE);
                params.topMargin = 0;
            }

            // contents
            holder.textViewContents.setText(item.getContents());

        } catch (Exception e) {
            TLog.e("Exception -> " + e);
        }
    }

    @Override
    public void addItem(HeaderDataModel item) {
//        super.addItem(item);
        mList.add(item);

        // 정렬 후 리스트 최신화
        Collections.sort(mList);
        notifyDataSetChanged();

    }

    class HeaderContentsViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout root;
        private LinearLayout linearLayoutDateLayer;
        private TextView textViewDate;
        private TextView textViewContents;
        private TextView textViewDay;

        public HeaderContentsViewHolder(@NonNull View itemView) {
            super(itemView);

            root = (LinearLayout) itemView.findViewById(R.id.root);
            linearLayoutDateLayer = (LinearLayout) itemView.findViewById(R.id.linearLayoutDateLayer);
            textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);
            textViewContents = (TextView) itemView.findViewById(R.id.textViewContents);
            textViewDay = (TextView) itemView.findViewById(R.id.textViewDay);

        }
    }
}

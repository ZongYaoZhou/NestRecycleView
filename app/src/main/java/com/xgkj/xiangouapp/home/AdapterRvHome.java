package com.xgkj.xiangouapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 */

public class AdapterRvHome extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<String> mDatas;

    public AdapterRvHome(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}

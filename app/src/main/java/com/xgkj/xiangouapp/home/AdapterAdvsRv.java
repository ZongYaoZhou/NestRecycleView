package com.xgkj.xiangouapp.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xgkj.xiangouapp.R;
import com.xgkj.xiangouapp.tools.CustomImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */

public class AdapterAdvsRv extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<ChildHomeBean> mBeanList;

    public void setBeanList(List<ChildHomeBean> beanList) {
        mBeanList = beanList;
    }

    public List<ChildHomeBean> getBeanList() {
        return mBeanList;
    }

    public AdapterAdvsRv(Context context, List<ChildHomeBean> beanList) {
        mContext = context;
        mBeanList = beanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advs_recycle,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            //"美女"
//            viewHolder.mTextView.setText(mBeanList.get(position).getTitle());
            //R.mipmap.girl_v
            viewHolder.mCustomImageView.setImageResource(mBeanList.get(position).getImgSrc());
        }
    }

    @Override
    public int getItemCount() {
        return mBeanList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private CustomImageView mCustomImageView;
//        private TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mCustomImageView = (CustomImageView) itemView.findViewById(R.id.civ_item_advs_recycle);
//            mTextView = (TextView) itemView.findViewById(R.id.tvi);
        }
    }

}

package com.xgkj.xiangouapp.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */

public abstract class BaseAdapter< T, H extends BaseViewHolder> extends RecyclerView.Adapter<BaseViewHolder> {
    public Context mContext;
    protected List<T> mDatas;
    protected  int mLayoutResId;

    /**
     * 提供item监听
     */
    protected OnMineItemClickListener mOnItemClickListener;
    public interface OnMineItemClickListener {
        void onMineItemClick(View view, int position);
        void onMineItemLongClick(View view , int position);
    }
    public void setOnMineItemClickListener(OnMineItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public void setOnMineItemLongClickListenter(OnMineItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public BaseAdapter(Context context, int mLayoutResId, List<T> mDatas) {
        mContext = context;
        this.mDatas = mDatas;
        this.mLayoutResId = mLayoutResId;
//        mOnItemClickListener = onItemClickListener;
    }

    protected abstract void bindData(BaseViewHolder holder, T t);

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder = BaseViewHolder.createViewHolder(mContext,parent,mLayoutResId, mOnItemClickListener);
        Log.e("BaseViewHolder", "onCreateViewHolder: " +holder.itemView.getId());
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        T t = getItem(position);
        bindData(holder,t);
//        Log.e("initView", "onBindViewHolder: "+holder );
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    public T getItem(int position){
        return mDatas.get(position);
    }

    public List<T> getDatas(){
        return mDatas;
    }
    public void clearData(){
        mDatas.clear();
        notifyItemRangeChanged(0,mDatas.size());
    }
    public void addData(List<T> datas){
        addData(0,datas);
    }
    public void addData(int position,List<T> datas){
        if (datas != null && datas.size()>0) {
            mDatas.addAll(datas);
            notifyItemRangeChanged(position,mDatas.size());
        }
    }


}

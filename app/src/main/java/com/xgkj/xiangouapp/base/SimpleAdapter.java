package com.xgkj.xiangouapp.base;

import android.content.Context;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */

public abstract class SimpleAdapter<T> extends BaseAdapter<T,BaseViewHolder>{

    public SimpleAdapter(Context context, int mLayoutResId, List<T> mDatas) {
        super(context, mLayoutResId, mDatas);
    }
}

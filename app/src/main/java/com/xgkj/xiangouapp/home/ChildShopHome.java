package com.xgkj.xiangouapp.home;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/3/2.
 */

public class ChildShopHome {

    public ImageView mChildIcon;
    public TextView mChildtext;
    public TextView mEnterchildtext;
    public RecyclerView mRecyclerView;;
    public LinearLayout mLinearLayout;

    public LinearLayout getLinearLayout() {
        return mLinearLayout;
    }

    public void setLinearLayout(LinearLayout linearLayout) {
        mLinearLayout = linearLayout;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
    }

    public ImageView getChildIcon() {
        return mChildIcon;
    }

    public void setChildIcon(ImageView childIcon) {
        mChildIcon = childIcon;
    }

    public TextView getEnterchildtext() {
        return mEnterchildtext;
    }

    public void setEnterchildtext(TextView enterchildtext) {
        mEnterchildtext = enterchildtext;
    }

    public TextView getChildtext() {
        return mChildtext;
    }

    public void setChildtext(TextView childtext) {
        mChildtext = childtext;
    }
}

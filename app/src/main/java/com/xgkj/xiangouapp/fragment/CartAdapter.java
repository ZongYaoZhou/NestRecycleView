package com.xgkj.xiangouapp.fragment;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.xgkj.xiangouapp.R;
import com.xgkj.xiangouapp.base.BaseViewHolder;
import com.xgkj.xiangouapp.base.SimpleAdapter;
import com.xgkj.xiangouapp.home.ChildHomeBean;
import com.xgkj.xiangouapp.tools.CustomImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */

public class CartAdapter extends SimpleAdapter<ChildHomeBean>{
    public CartAdapter(Context context, List<ChildHomeBean> mDatas) {
        super(context, R.layout.item_recycle_cart, mDatas);
    }


    @Override
    protected void bindData(BaseViewHolder holder, ChildHomeBean childHomeBean) {
            Log.e("initview", "holder: "+holder );
        if (holder.itemView.isInLayout()) {
            Log.e("initview", "holder !=null: "+holder );
            CustomImageView customImageView = holder.getCustomView(R.id.civ_cart_recycle);
            customImageView.setType(CustomImageView.TYPE_ROUND);
            customImageView.setImageResource(childHomeBean.getImgSrc());

            holder.getTextView(R.id.tv_cart_recycle).setText(childHomeBean.getTitle());
        }
    }
}

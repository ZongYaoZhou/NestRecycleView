package com.xgkj.xiangouapp.home;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.xgkj.xiangouapp.R;
import com.xgkj.xiangouapp.base.BaseViewHolder;
import com.xgkj.xiangouapp.base.SimpleAdapter;
import com.xgkj.xiangouapp.tools.CustomImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */

public class ReferralsAdapter extends SimpleAdapter<ChildHomeBean>{
    public ReferralsAdapter(Context context, int mLayoutResId, List<ChildHomeBean> mDatas) {
        super(context, mLayoutResId, mDatas);
    }

    @Override
    protected void bindData(BaseViewHolder holder, ChildHomeBean childHomeBean) {
        Log.e("childHomeBean", "ReferralsAdapter: "+childHomeBean.toString() );
//        if (holder.itemView.isInLayout() && childHomeBean.getImgSrc()!=0) {
            CustomImageView mCustomImageView = holder.getCustomView(R.id.civ_item_referrals_recycle);
            mCustomImageView.setImageResource(childHomeBean.getImgSrc());
//            ContextUtils.setLayoutParams(1,250,250,mCustomImageView);

            TextView mTextView = holder.getTextView(R.id.tv_item_referrals_recycle);
            mTextView.setText(childHomeBean.getTitle());
//        }
    }
}

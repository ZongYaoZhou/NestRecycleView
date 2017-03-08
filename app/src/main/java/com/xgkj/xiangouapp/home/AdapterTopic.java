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
 * Created by Administrator on 2017/3/7.
 */

public class AdapterTopic extends SimpleAdapter<ChildHomeBean>{
    public AdapterTopic(Context context, int mLayoutResId, List<ChildHomeBean> mDatas) {
        super(context, mLayoutResId, mDatas);
    }

    @Override
    protected void bindData(BaseViewHolder holder, ChildHomeBean childHomeBean) {
        Log.e("childHomeBean", "AdapterTopic: "+childHomeBean.toString() );
//        if (holder.itemView.isInLayout() && childHomeBean.getImgSrc()!=0
//                && childHomeBean.getTitle()!=null){
            CustomImageView mCustomImageView = holder.getCustomView(R.id.civ_item_topic_recycle);
            mCustomImageView.setImageResource(childHomeBean.getImgSrc());
//            ContextUtils.setLayoutParams(1,250,250,mCustomImageView);

            TextView mTextView = holder.getTextView(R.id.tv_item_topic_recycle);
            mTextView.setText(childHomeBean.getTitle());
//        }
    }
}

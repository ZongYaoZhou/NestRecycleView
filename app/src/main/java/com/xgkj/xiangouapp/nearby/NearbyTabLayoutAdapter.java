package com.xgkj.xiangouapp.nearby;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xgkj.xiangouapp.R;
import com.xgkj.xiangouapp.tools.ContextUtils;

import java.util.List;


/**
 * Created by asus on 2017/2/7.
 */

public class NearbyTabLayoutAdapter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;
    private String[] tabs ;
    private Context mContext;
    private TextView mTabTv;
    private ImageView mTabIv;

    public NearbyTabLayoutAdapter(Context mContext,FragmentManager fm, List<Fragment> list_fragment, String[] tabs) {
        super(fm);
        this.mContext = mContext;
        this.list_fragment =list_fragment;
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

//    @Override  //此方法用来显示tab上的名字
//    public CharSequence getPageTitle(int position) {
//        if (position==0){
//            Drawable drawable = ContextCompat.getDrawable(mContext,R.mipmap.nearby_goods_addr_icon);
//            drawable.setBounds(0,0,drawable.getIntrinsicWidth()/2,drawable.getIntrinsicHeight()/2);
//            ImageSpan imageSpan = new ImageSpan(drawable);
//            SpannableString spannableString = new SpannableString(tabs[0]+" ");
//            spannableString.setSpan(imageSpan,4,5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//            return spannableString;
//        }else {
//            return tabs[position % tabs.length];
//        }
//    }

    public View getTabItemView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.tab_item_nearby,null);
        mTabTv = (TextView) view.findViewById(R.id.tv_title_tab);
        mTabTv.setText(tabs[position]);
        if (position==0){
            mTabIv = (ImageView) view.findViewById(R.id.iv_title_tab);
            mTabIv.setVisibility(View.VISIBLE);
        }
        return view;
    }

    public TextView getTabTv() {
        return mTabTv;
    }

    public ImageView getTabIv() {
        return mTabIv;
    }
}



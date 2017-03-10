package com.xgkj.xiangouapp.nearby;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.xgkj.xiangouapp.R;
import com.xgkj.xiangouapp.nearby.frag.NearbyGoodsFrag;
import com.xgkj.xiangouapp.nearby.frag.NearbyPreferentialFrag;
import com.xgkj.xiangouapp.nearby.frag.NearbyStoreFrag;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/2/28.
 */

public class NearbyFragment extends Fragment implements View.OnClickListener{
//    private TextView mTitleTv;
//    private ImageView mClassifyIv,mScanIv,mRockIv;
    @BindView(R.id.classify_nearby_iv)
    ImageView mClassifyIv;
    @BindView(R.id.scan_nearby_iv)
    ImageView mScanIv;
    @BindView(R.id.rock_nearby_iv)
    ImageView mRockIv;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private NearbyTabLayoutAdapter mLayoutAdapter;
    private List<Fragment> mTabFragList;
    private String[] tabTitles;
    private PopupWindow mPopupWindow;
    private List<TextView> mPpwTvs;
    private int nearyDistance;//附近距离

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby,container,false);
        ButterKnife.bind(this,view);

        mClassifyIv.setOnClickListener(this);
        mScanIv.setOnClickListener(this);
        mRockIv.setOnClickListener(this);
        initTabFragViews(view);

        return view;

    }



    private void initTabFragViews(View view) {
        tabTitles = new String[]{"附近商品","附近商店","附近优惠"};
        mTabFragList = new ArrayList<>();
        mTabFragList.add(new NearbyGoodsFrag());
        mTabFragList.add(new NearbyStoreFrag());
        mTabFragList.add(new NearbyPreferentialFrag());
        mViewPager = (ViewPager) view.findViewById(R.id.frag_nearby_vp);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs_nearby_tl);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        for (int i=0; i<tabTitles.length; i++) {
//            mTabLayout.addTab(mTabLayout.newTab().setText(tabTitles[i]));
//        }
        mLayoutAdapter = new NearbyTabLayoutAdapter(getContext(),getChildFragmentManager(),mTabFragList,tabTitles);
        mViewPager.setAdapter(mLayoutAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i=0; i<tabTitles.length; i++){
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab!=null){
                tab.setCustomView(mLayoutAdapter.getTabItemView(i));
                if (tab.getCustomView() !=null) {
                    View tabView = (View) tab.getCustomView().getParent();
                    tabView.setTag("tab"+i);
                    tabView.setOnClickListener(this);
                }
            }
        }
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
                for (int i=0; i<mTabFragList.size(); i++) {
                    if (mTabFragList.get(i).isAdded()) {
                        if (i==position) {
                            getChildFragmentManager().beginTransaction()
                                    .show(mTabFragList.get(i))
                                    .commit();
                        }else {
                            getChildFragmentManager().beginTransaction()
                                    .hide(mTabFragList.get(i))
                                    .commit();
                        }
                    }
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.classify_nearby_iv:
                Toast.makeText(getContext(), "看分类了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scan_nearby_iv:
                Toast.makeText(getContext(), "扫描个锤锤", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rock_nearby_iv:
                Toast.makeText(getContext(), "come on baby，摇起来", Toast.LENGTH_SHORT).show();
                break;
            default:
                switch ((String) v.getTag()) {
                    case "tab0":
                        if (mViewPager.getCurrentItem()==0)
                        showPopupwindow(v);
                        Toast.makeText(getContext(), "商品", Toast.LENGTH_SHORT).show();
                        break;
                    case "tab1":
                        Toast.makeText(getContext(), "Store", Toast.LENGTH_SHORT).show();
                        break;
                    case "tab2":
                        Toast.makeText(getContext(), "mon mon", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                    case "ppw0":
                        nearyDistance = 1000000;
                        break;
                    case "ppw1":
                        nearyDistance = 1000;
                        break;
                    case "ppw2":
                        nearyDistance = 2000;
                        break;
                    case "ppw3":
                        nearyDistance = 3000;
                        break;
                    case "ppw4":
                        nearyDistance = 4000;
                        break;
                    case "ppw5":
                        nearyDistance = 5000;
                        break;
                }
        }
    }

    private void showPopupwindow(View view) {
        View mContentView = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow_nearby_goods,null);
        mPpwTvs = new ArrayList<>();
        mPpwTvs.add((TextView) mContentView.findViewById(R.id.all_ppw));
        mPpwTvs.add((TextView) mContentView.findViewById(R.id.one_ppw));
        mPpwTvs.add((TextView) mContentView.findViewById(R.id.three_ppw));
        mPpwTvs.add((TextView) mContentView.findViewById(R.id.four_ppw));
        mPpwTvs.add((TextView) mContentView.findViewById(R.id.five_ppw));
        for (int i = 0; i< mPpwTvs.size(); i++) {
            mPpwTvs.get(i).setTag("ppw"+i);
            mPpwTvs.get(i).setOnClickListener(this);
        }

        mPopupWindow = new PopupWindow(mContentView,view.getWidth(), ViewPager.LayoutParams.WRAP_CONTENT,true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        mPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.popupwindow_bg));
        mPopupWindow.showAsDropDown(view);
    }
}

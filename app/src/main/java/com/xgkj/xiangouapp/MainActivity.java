package com.xgkj.xiangouapp;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.xgkj.xiangouapp.fragment.CartFragment;
import com.xgkj.xiangouapp.fragment.ClassifyFragment;
import com.xgkj.xiangouapp.home.HomeFragment;
import com.xgkj.xiangouapp.fragment.MineFragment;
import com.xgkj.xiangouapp.fragment.NearbyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

//    TextView v1,v2;

//
//    @BindViews({R.id.iwt1,R.id.iwt2})
//    ImageWithText[] iwt;

    private FragmentTabHost mFragmentTabHost;
    private LayoutInflater mInflater;
    private List<Tab> mTabs;
    private TabHost.TabSpec mTabSpec;
    private int mCurrentNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
//        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
//        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.custom_actionbar);
//        v1 = (TextView) findViewById(R.id.head).findViewById(R.id.tvNmae);
//        v2 = (TextView) findViewById(R.id.foot).findViewById(R.id.tvNmae);
//        v2.setText("gogogo");
        ButterKnife.bind(this);
        initTabHost();
    }

    //初始化底栏的tabs
    private void initTabHost() {
        Tab home = new Tab(R.string.home,R.drawable.icon_home_select,HomeFragment.class);
        Tab classify = new Tab(R.string.classify,R.drawable.icon_classify_select,ClassifyFragment.class);
        Tab nearby = new Tab(R.string.nearby,R.drawable.icon_nearby_select,NearbyFragment.class);
        Tab cart = new Tab(R.string.shopping_cart,R.drawable.icon_cart_select,CartFragment.class);
        Tab mine = new Tab(R.string.mine,R.drawable.icon_mine_select,MineFragment.class);
        mTabs = new ArrayList<>();
        mTabs.add(home);
        mTabs.add(classify);
        mTabs.add(nearby);
        mTabs.add(cart);
        mTabs.add(mine);

        mInflater = LayoutInflater.from(this);
        mFragmentTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mFragmentTabHost.setup(this,getSupportFragmentManager(),R.id.fragsgroup);
        mCurrentNum = 0;
        for (Tab tab:mTabs
             ) {
            mTabSpec = mFragmentTabHost.newTabSpec(getString(tab.getTitle()));
            mTabSpec.setIndicator(buildIndicator(tab,mCurrentNum));
            mFragmentTabHost.addTab(mTabSpec,tab.getFrag(),null);
            mCurrentNum++;
        }
        //去掉分隔线
        mFragmentTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        //开始默认选中第一个tab
        mFragmentTabHost.setCurrentTab(0);

        //设置tab监听--i是tab的下标
//        mFragmentTabHost.getTabWidget().getChildAt(i).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    private View buildIndicator(Tab tab,int currentNum) {
        View view =mInflater.inflate(R.layout.tab_indicator,null);

//        RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.item_tab_rl);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab_indicator);
        TextView text = (TextView) view.findViewById(R.id.text_tab_indicator);

        img.setImageResource(tab.getIcon());
        text.setText(tab.getTitle());
        if (currentNum==2) {
            text.setVisibility(View.GONE);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) img.getLayoutParams();
            params.width=100;
            params.height=100;
            img.setLayoutParams(params);
        }
        return view;
    }


}

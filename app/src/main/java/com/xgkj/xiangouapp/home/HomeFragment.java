package com.xgkj.xiangouapp.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xgkj.xiangouapp.tools.CustomImageView;
import com.xgkj.xiangouapp.tools.GlideImageLoader;
import com.xgkj.xiangouapp.ImageWithText;
import com.xgkj.xiangouapp.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
    private List<String> imgUrls,titles;
    private Banner homeBanner;

    private ChildShopHome boutique,referrals;
    private ImageWithText mReferralsIWT;
    private ImageWithText mBoutiqueIWT;

    public static HomeFragment newInstance() {
        HomeFragment homeFrag = new HomeFragment();
        return homeFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        //初始化Banner
        initData();
        initBanner(view);
        //
        initBoutique(view);
        initReferrals(view);

        return view;

    }

    private void initBoutique(View view) {
        boutique = new ChildShopHome();
        boutique.mLinearLayout = (LinearLayout) view.findViewById(R.id.boutique_home).findViewById(R.id.childmode_shop_home);
        LinearLayout.LayoutParams mLParms = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,dpTopx(150));
        boutique.mLinearLayout.setLayoutParams(mLParms);
        boutique.mChildIcon = (ImageView) view.findViewById(R.id.boutique_home).findViewById(R.id.icon_child_shop);
        boutique.mChildtext = (TextView) view.findViewById(R.id.boutique_home).findViewById(R.id.text_child_shop);
        boutique.mEnterchildtext = (TextView) view.findViewById(R.id.boutique_home).findViewById(R.id.all_enter);
        boutique.mRecyclerView = (RecyclerView) view.findViewById(R.id.boutique_home).findViewById(R.id.recyclev_shop_home);

        boutique.mChildIcon.setImageResource(R.mipmap.boutique);
        boutique.mChildtext.setText("精品店家");
        boutique.mEnterchildtext.setVisibility(View.GONE);


        mBoutiqueIWT.setImageType(CustomImageView.TYPE_CIRCLE);
        mBoutiqueIWT.getCiv().setImageResource(R.mipmap.girl_h);
        mBoutiqueIWT.getTv().setText("美女");
        mBoutiqueIWT.getTv().setTextColor(getResources().getColor(R.color.black_textcolor));
    }

    private void initReferrals(View view) {
        referrals = new ChildShopHome();
        referrals.mLinearLayout = (LinearLayout) view.findViewById(R.id.referrals_home).findViewById(R.id.childmode_shop_home);
        LinearLayout.LayoutParams mLParms = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,dpTopx(180));
        referrals.mLinearLayout.setLayoutParams(mLParms);
        referrals.mChildIcon = (ImageView) view.findViewById(R.id.referrals_home).findViewById(R.id.icon_child_shop);
        referrals.mChildtext = (TextView) view.findViewById(R.id.referrals_home).findViewById(R.id.text_child_shop);
        referrals.mEnterchildtext = (TextView) view.findViewById(R.id.referrals_home).findViewById(R.id.all_enter);
        referrals.mRecyclerView = (RecyclerView) view.findViewById(R.id.referrals_home).findViewById(R.id.recyclev_shop_home);
        referrals.mChildIcon.setImageResource(R.mipmap.goods);
        referrals.mChildtext.setText("商品推荐");
        referrals.mEnterchildtext.setOnClickListener(this);

//            referralsIWT.setImageType(CustomImageView.TYPE_ROUND);
        mReferralsIWT.getCiv().setImageResource(R.mipmap.girl_v);
        mReferralsIWT.getCiv().setType(CustomImageView.TYPE_ROUND);
        mReferralsIWT.getTv().setText("侣朋友");
        mReferralsIWT.getTv().setTextColor(getResources().getColor(R.color.black_textcolor));
    }


    private void initData() {
        imgUrls = new ArrayList<>();
        imgUrls.add("http://img03.sogoucdn.com/app/a/100520024/55c66d7db6c9abbadfe66e0c243ffa54");
        imgUrls.add("http://img02.sogoucdn.com/app/a/100520024/27c434caac5cc42ccc5fa2b7afc2040e");
        imgUrls.add("http://img02.sogoucdn.com/app/a/100520024/70182656db6c26ae6ca8516a1ce19aa8");
        imgUrls.add("http://img02.sogoucdn.com/app/a/100520024/6ecbf479722b9f1c3afe27a052700830");
        imgUrls.add("http://img02.sogoucdn.com/app/a/100520024/4cfd53be2263282410d17319b6417260");
        titles = new ArrayList<>();
        titles.add("美女1");
        titles.add("美女2");
        titles.add("美女3");
        titles.add("美女4");
        titles.add("美女5");

//        iwt[0].setText("测试文字1");
//        iwt[1].setText("测试文字2");
//        for (ImageWithText i:iwt
//             ) {
//            i.setTextColor(Color.parseColor("#0000ff"));
//            i.setTextSize(25);
//        }
    }

    private void initBanner(View view) {
        homeBanner = (Banner) view.findViewById(R.id.banner_home).findViewById(R.id.banner);
        //设置banner样式
        homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置指示器位置（当banner模式中有指示器时）
        homeBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        homeBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        homeBanner.setImages(imgUrls);
        //设置banner动画效果
        homeBanner.setBannerAnimation(Transformer.Default);
        //设置轮播时间
        homeBanner.setDelayTime(3000);
        //设置自动轮播
        homeBanner.isAutoPlay(true);
        //设置标题集合（当banner样式有显示title时）
        homeBanner.setBannerTitles(titles);
        homeBanner.start();
    }

    //单位dp转单位px
    public int dpTopx(int dp){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, getResources().getDisplayMetrics());
    }

    @Override
    public void onStart() {
        super.onStart();
        homeBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        homeBanner.stopAutoPlay();
    }

    @Override
    public void onClick(View v) {

    }
}

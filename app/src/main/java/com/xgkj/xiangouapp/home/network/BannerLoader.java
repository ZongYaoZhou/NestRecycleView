package com.xgkj.xiangouapp.home.network;

import com.xgkj.xiangouapp.home.BannerBean;
import com.xgkj.xiangouapp.tools.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */

public class BannerLoader {

    private ArrayList<String> imgUrls;
    private Banner mBanner;
    private ArrayList<String> titles;
    private List<BannerBean> bannerList;

    public BannerLoader(Banner banner) {
        mBanner = banner;
    }

    /**
     * 待修改返回值 List<BannerBean>
     */
    public void getBannerList() {
        //测试的数据
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
//        return  bannerList;
    }

    /**
     * 可根据后台接口返回的json数据添加此属性： , List<BannerBean> bannerList
     */
    public void initBanner() {
        getBannerList();
//        for (int i=0; i<bannerList.size(); i++) {
//            imgUrls.clear();
//            titles.clear();
//            imgUrls.add(bannerList.get(i).getImgUrl());
//            titles.add(bannerList.get(i).getTitle());
//        }
//        mBanner = (Banner) view.findViewById(parentId).findViewById(bannerId);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(imgUrls);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.Default);
        //设置轮播时间
        mBanner.setDelayTime(3000);
        //设置自动轮播
        mBanner.isAutoPlay(true);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(titles);
        mBanner.start();
    }
}

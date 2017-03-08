package com.xgkj.xiangouapp.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xgkj.xiangouapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
//
//    private ChildHomeBean boutique,referrals;
//    private ImageWithText mReferralsIWT;
//    private ImageWithText mBoutiqueIWT;
    private View mFragView;

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
        mFragView = inflater.inflate(R.layout.fragment_home,container,false);

//        //初始化Banner
//        initData();
//        initBanner(view);
//        //
//        initBoutique(view);
//        initReferrals(view);
        initView();

        return mFragView;

    }

    private void initView() {

        RecyclerView rvHome = (RecyclerView) mFragView.findViewById(R.id.rv_frag_home);
        GridLayoutManager glm = new GridLayoutManager(getContext(),60,GridLayoutManager.VERTICAL,false);
        rvHome.setLayoutManager(glm);

        List<ChildHomeBean> childHomeBeanList = new ArrayList<ChildHomeBean>();
        childHomeBeanList.add(new ChildHomeBean("", "my titles develop by random1"));
        childHomeBeanList.add(new ChildHomeBean("", "my titles develop by random2"));
        childHomeBeanList.add(new ChildHomeBean("", "my titles develop by random3"));
        childHomeBeanList.add(new ChildHomeBean("", "my titles develop by moremoremoremoremoremoremoremore random4"));
        childHomeBeanList.add(new ChildHomeBean("", "my titles develop by random5"));
        childHomeBeanList.add(new ChildHomeBean("", "my titles develop by moremoremoremoremoremoremoremore random6"));
        childHomeBeanList.add(new ChildHomeBean("", "my titles develop by random7"));
        childHomeBeanList.add(new ChildHomeBean("", "my titles develop by moremoremoremoremoremoremoremore random8"));

        AdapterRvHome adapterRvHome = new AdapterRvHome(getContext(),childHomeBeanList);
        rvHome.setAdapter(adapterRvHome);

    }

//    private void initReferrals(View view) {
//        referrals = new ChildHomeBean();
//        referrals.mLinearLayout = (LinearLayout) view.findViewById(R.id.referrals_home).findViewById(R.id.childmode_shop_home);
//        LinearLayout.LayoutParams mLParms = new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,dpTopx(180));
//        referrals.mLinearLayout.setLayoutParams(mLParms);
//        referrals.mChildIcon = (ImageView) view.findViewById(R.id.referrals_home).findViewById(R.id.icon_child_shop);
//        referrals.mChildtext = (TextView) view.findViewById(R.id.referrals_home).findViewById(R.id.text_child_shop);
//        referrals.mEnterchildtext = (TextView) view.findViewById(R.id.referrals_home).findViewById(R.id.all_enter);
//        referrals.mRecyclerView = (RecyclerView) view.findViewById(R.id.referrals_home).findViewById(R.id.recyclev_shop_home);
//        referrals.mChildIcon.setImageResource(R.mipmap.goods);
//        referrals.mChildtext.setText("商品推荐");
//        referrals.mEnterchildtext.setOnClickListener(this);
//
////            referralsIWT.setImageType(CustomImageView.TYPE_ROUND);
//        mReferralsIWT.getCiv().setImageResource(R.mipmap.girl_v);
//        mReferralsIWT.getCiv().setType(CustomImageView.TYPE_ROUND);
//        mReferralsIWT.getTv().setText("侣朋友");
//        mReferralsIWT.getTv().setTextColor(getResources().getColor(R.color.black_textcolor));
//    }

    @Override
    public void onStart() {
        super.onStart();
//        homeBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
//        homeBanner.stopAutoPlay();
    }

    @Override
    public void onClick(View v) {

    }
}

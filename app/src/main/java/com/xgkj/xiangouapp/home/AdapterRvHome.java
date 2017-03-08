package com.xgkj.xiangouapp.home;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xgkj.xiangouapp.R;
import com.xgkj.xiangouapp.home.network.BannerLoader;
import com.xgkj.xiangouapp.tools.CustomImageView;
import com.xgkj.xiangouapp.tools.GlideImageLoader;
import com.xgkj.xiangouapp.tools.ItemIntervalDecoration;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/3/2.
 */

public class AdapterRvHome extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<ChildHomeBean> mListDatas;

    //
    public static final int ALL_ITEM_COUNT = 5;
    //不同recycle的type
    public static final int RVTYPE_DEFAULT = 0xffff;
    public static final int RVTYPE_BANNER = 0xff01;
    public static final int RVTYPE_BOUTIQUE = 0xff02;
    public static final int RVTYPE_REFERRALS = 0xff03;
    public static final int RVTYPE_ADVS = 0xff04;
    public static final int RVTYPE_TOPIC = 0xff05;


    public List<ChildHomeBean> getListDatas(){
        return mListDatas;
    }
//int srcId,
    public AdapterRvHome(Context context, List<ChildHomeBean> datas) {
        mContext = context;
        mListDatas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case RVTYPE_BANNER:
                return new BannerViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_banner_home,parent,false));
            case RVTYPE_BOUTIQUE:
                return new BoutiqueViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_boutique_home,parent,false));
            case RVTYPE_REFERRALS:
                return new ReferralsViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_referrals_home,parent,false));
            case RVTYPE_ADVS:
                return new AdvsViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advs_recycle,parent,false));
            case RVTYPE_TOPIC:
                return new TopicViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_topic_home,parent,false));
            case RVTYPE_DEFAULT:
                return new DefaultViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_default_home,parent,false));
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {
            bindBannerType((BannerViewHolder) holder,position);
        }else if (holder instanceof BoutiqueViewHolder) {
            bindBoutiqueType((BoutiqueViewHolder) holder,position);
        }else if (holder instanceof ReferralsViewHolder) {
            bindReferralsType((ReferralsViewHolder) holder,position);
        }else if (holder instanceof AdvsViewHolder) {
            bindAdvsType((AdvsViewHolder) holder,position);
        }else if (holder instanceof TopicViewHolder) {
            bindTopicType((TopicViewHolder) holder,position);
        }else if (holder instanceof DefaultViewHolder) {
            bindDefaultType((DefaultViewHolder) holder,position);
        }
    }

//    @Override
//    public long getItemId(int position) {
//        return position;
//    }

    //此recycleview的item的总个数
    @Override
    public int getItemCount() {
        return ALL_ITEM_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return RVTYPE_BANNER;
            case 1:
                return RVTYPE_BOUTIQUE;
            case 2:
                return RVTYPE_REFERRALS;
            case 3:
                return RVTYPE_ADVS;
            case 4:
                return RVTYPE_TOPIC;
            default:
                return RVTYPE_DEFAULT;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    switch ( getItemViewType(position) ) {
                        case RVTYPE_BANNER:
                        case RVTYPE_ADVS:

                        case RVTYPE_BOUTIQUE:
//                            return 15;
                        case RVTYPE_REFERRALS:
//                            return 12;
                        case RVTYPE_TOPIC:
//                            return 10;
                            return gridLayoutManager.getSpanCount();
                        default:
//                            return 30;
                            return 1;
                    }

                }
            });
        }
    }

    /**
     * 下面是5种不同的Recycleview布局的bindview
     * @param holder
     * @param position
     */
    private void bindBannerType(BannerViewHolder holder,int position){
        BannerLoader homeBanner = new BannerLoader(holder.mHomeBanner);
        homeBanner.initBanner();
    }
    private void bindBoutiqueType(BoutiqueViewHolder holder,int position){
        List<ChildHomeBean> list = new ArrayList<>();
        //test data ,here,you can update
        for (int i=0;i<4;i++) {
            list.add(new ChildHomeBean(R.mipmap.girl_v,"街角的美女"));
        }
//        BoutiqueAdapter Adapter = new BoutiqueAdapter(holder.mBoutiqueRv.getContext(),list);
//        holder.mBoutiqueRv.setAdapter(Adapter);
        holder.mBoutiqueRv.setLayoutManager(
                new GridLayoutManager(holder.mBoutiqueRv.getContext(),4,GridLayoutManager.VERTICAL,false));
        holder.mBoutiqueRv.setPadding(30,11,30,9);
        holder.mBoutiqueRv.addItemDecoration(
                new ItemIntervalDecoration(18,0,0));
        holder.mBoutiqueRv.setNestedScrollingEnabled(false);

        BoutiqueAdapter mAdapter = new BoutiqueAdapter(mContext,R.layout.item_boutique_recycle,list);
        holder.mBoutiqueRv.setAdapter(mAdapter);
    }
    private void bindReferralsType(ReferralsViewHolder holder,int position){
        List<ChildHomeBean> list = new ArrayList<>();
        //test data ,here,you can update
        for (int i=0;i<5;i++) {
            list.add(new ChildHomeBean(R.mipmap.girl_v,"广袖流仙裙"));
        }
        holder.mReferralsRv.setLayoutManager(
                new GridLayoutManager(holder.mReferralsRv.getContext(),5,GridLayoutManager.VERTICAL,false));
        holder.mReferralsRv.setPadding(8,11,8,9);
        holder.mReferralsRv.addItemDecoration(
                new ItemIntervalDecoration(5,0,0));
        ReferralsAdapter mAdapter = new ReferralsAdapter(mContext,R.layout.item_referrals_recycle,list);
        holder.mReferralsRv.setAdapter(mAdapter);
        holder.mReferralsRv.setNestedScrollingEnabled(false);
    }
    private void bindAdvsType(AdvsViewHolder holder,int position){
        //test data ,here,you can update
        if (holder.mAdvsCiv!=null){
            String imgUrl = "http://img02.sogoucdn.com/app/a/100520024/27c434caac5cc42ccc5fa2b7afc2040e";
            GlideImageLoader imageLoader = new GlideImageLoader();
            imageLoader.displayImage(mContext,imgUrl,holder.mAdvsCiv);
        }
    }
    private void bindTopicType(TopicViewHolder holder,int position){
        List<ChildHomeBean> list = new ArrayList<>();
        //test data ,here,you can update
        for (int i=0;i<6;i++) {
            list.add(new ChildHomeBean(R.mipmap.girl_v,"￥199.00"));
        }
        if (holder.mTopicCiv!=null){
            String imgUrl = "http://img03.sogoucdn.com/app/a/100520024/55c66d7db6c9abbadfe66e0c243ffa54";
            GlideImageLoader imageLoader = new GlideImageLoader();
            imageLoader.displayImage(mContext,imgUrl,holder.mTopicCiv);
        }
        holder.mTopicRv.setLayoutManager(
                new GridLayoutManager(holder.mTopicRv.getContext(),6,GridLayoutManager.VERTICAL,false));
        holder.mTopicRv.setPadding(8,8,8,0);
        holder.mTopicRv.addItemDecoration(new ItemIntervalDecoration(7,0,0));
        AdapterTopic mAdapter = new AdapterTopic(mContext,R.layout.item_topic_recycle,list);
        holder.mTopicRv.setAdapter(mAdapter);
        holder.mTopicRv.setNestedScrollingEnabled(true);
    }
    private void bindDefaultType(DefaultViewHolder holder,int position){
        String imgUrl = "http://img03.sogoucdn.com/app/a/100520024/55c66d7db6c9abbadfe66e0c243ffa54";
        holder.mTextView.setText("专题");
        holder.mCustomImageView.setType(CustomImageView.TYPE_ROUND);
        GlideImageLoader imageLoader = new GlideImageLoader();
        imageLoader.displayImage(mContext,imgUrl,holder.mCustomImageView);
    }
    /**
     *下面是5种Recycleview布局
     */
    public class BannerViewHolder extends RecyclerView.ViewHolder {
        public Banner mHomeBanner;
        public BannerViewHolder(View itemView) {
            super(itemView);
            mHomeBanner = (Banner) itemView.findViewById(R.id.homeBanner);
        }
    }
    public class BoutiqueViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView mBoutiqueRv;
        public BoutiqueViewHolder(View itemView) {
            super(itemView);
            mBoutiqueRv = (RecyclerView) itemView.findViewById(R.id.child_boutique_recycle);
        }
    }
    public class ReferralsViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView mReferralsRv;
        public ReferralsViewHolder(View itemView) {
            super(itemView);
            mReferralsRv = (RecyclerView) itemView.findViewById(R.id.child_referrals_recycle);
        }
    }
    public class AdvsViewHolder extends RecyclerView.ViewHolder {
        private CustomImageView mAdvsCiv;
        public AdvsViewHolder(View itemView) {
            super(itemView);
            mAdvsCiv = (CustomImageView) itemView.findViewById(R.id.civ_item_advs_recycle);
        }
    }
    public class TopicViewHolder extends RecyclerView.ViewHolder {
        public CustomImageView mTopicCiv;
        public RecyclerView mTopicRv;
        public TopicViewHolder(View itemView) {
            super(itemView);
            mTopicCiv = (CustomImageView) itemView.findViewById(R.id.advs_topic_civ);
            mTopicCiv.setType(CustomImageView.TYPE_ROUND);
            mTopicRv = (RecyclerView) itemView.findViewById(R.id.child_topic_recycle);
        }
    }
    public class DefaultViewHolder extends RecyclerView.ViewHolder {
        public CustomImageView mCustomImageView;
        public TextView mTextView;
        public DefaultViewHolder(View itemView) {
            super(itemView);
            mCustomImageView = (CustomImageView) itemView.findViewById(R.id.civ_default_recycle);
            mCustomImageView.setType(CustomImageView.TYPE_ROUND);
            mTextView = (TextView) itemView.findViewById(R.id.tv_default_recycle);
        }
    }

}

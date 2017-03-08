package com.xgkj.xiangouapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xgkj.xiangouapp.R;
import com.xgkj.xiangouapp.base.BaseAdapter;
import com.xgkj.xiangouapp.home.ChildHomeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */

public class CartFragment extends Fragment {
//    TextView tv;
    RecyclerView mRecyclerView;
    private View mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_cart,container,false);
        initView();
        return mView;

    }

    private void initView() {
//        tv = (TextView) mView.findViewById(R.id.tv_frag);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.cart_rv);
        GridLayoutManager glm = new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(glm);
//        tv.setText("购物车");

        List<ChildHomeBean> beanList = new ArrayList<>();
        for (int i=0;i<9;i++) {
            beanList.add(new ChildHomeBean(R.mipmap.girl_v,"base 美女"+i));
        }
        CartAdapter adapter = new CartAdapter(getContext(),beanList);
        adapter.setOnMineItemClickListener(new BaseAdapter.OnMineItemClickListener() {
            @Override
            public void onMineItemClick(View view, int position) {
                Toast.makeText(getActivity(), "recyclerview:"+mRecyclerView, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMineItemLongClick(View view, int position) {

            }
        });

        mRecyclerView.setAdapter(adapter);
    }


}

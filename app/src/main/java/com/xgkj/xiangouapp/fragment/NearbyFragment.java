package com.xgkj.xiangouapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xgkj.xiangouapp.R;

/**
 * Created by Administrator on 2017/2/28.
 */

public class NearbyFragment extends Fragment {
    TextView tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mode,container,false);
        tv = (TextView) view.findViewById(R.id.tv_frag);
        tv.setText("附近");
        return view;

    }
}

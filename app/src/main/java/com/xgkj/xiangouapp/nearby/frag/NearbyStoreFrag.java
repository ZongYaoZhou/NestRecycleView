package com.xgkj.xiangouapp.nearby.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xgkj.xiangouapp.R;

/**
 * Created by Administrator on 2017/3/9.
 */

public class NearbyStoreFrag extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby_store,container,false);
        return view;
    }
}

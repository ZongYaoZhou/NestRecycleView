package com.xgkj.xiangouapp.home;

/**
 * Created by Administrator on 2017/3/8.
 */

public class HomeChildBean {
    private int childType;
    private int childCount;
    private ChildHomeBean mChildHomeBean;

    public HomeChildBean(int childType) {
        this.childType = childType;
    }

    public HomeChildBean(int childType, int childCount) {
        this.childType = childType;
        this.childCount = childCount;
    }

    public int getChildType() {
        return childType;
    }

    public void setChildType(int childType) {
        this.childType = childType;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public ChildHomeBean getChildHomeBean() {
        return mChildHomeBean;
    }

    public void setChildHomeBean(ChildHomeBean childHomeBean) {
        mChildHomeBean = childHomeBean;
    }
}

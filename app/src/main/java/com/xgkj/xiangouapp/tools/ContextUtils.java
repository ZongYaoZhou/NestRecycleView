package com.xgkj.xiangouapp.tools;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2017/3/6.
 */

public class ContextUtils extends Application{
    /**
     * 不要忘了在清单文件里先注册此类
     */

    private static int phoneWidth,phoneHeight;//手机屏幕的宽高
    private static ContextUtils mContext;
    private static DisplayMetrics mDisplayMetrics;

    @Override
    public void onCreate() {

        mContext = this;
        super.onCreate();
        //获取手机屏幕的宽高
        mDisplayMetrics = getResources().getDisplayMetrics();
        phoneWidth = mDisplayMetrics.widthPixels;
        Log.e("phoneWidth", "onCreate: "+phoneWidth );
        phoneHeight = mDisplayMetrics.heightPixels;
    }
    public static ContextUtils getInstance() {
        return mContext;
    }

    /**
     * 以高度与宽度(手机屏幕的宽)的比来设置控件高度
     * 这里view的父布局是LinearLayout，类型设置是要根据具体控件来决定
     * @param view
     * @param scale
     */
    public static void setScaleLayoutParams(View view,float scale) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        params.width = phoneWidth;
        params.height = (int) (phoneWidth/scale);
        view.setLayoutParams(params);
    }
    /**
     * 以具体的宽度、高度来设置控件
     * 这里view的父布局是LinearLayout，类型设置是要根据具体控件来决定
     * @param view
     * @param width
     * @param height
     */
    public static void setLayoutParams(int type,int width,int height,View view) {
        ViewGroup.LayoutParams params = null;
        switch (type) {
            case 1:
                params = (RecyclerView.LayoutParams) view.getLayoutParams();
                break;
            case 2:
                params = (LinearLayout.LayoutParams) view.getLayoutParams();
                break;
        }
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }
    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     */
    public static int px2dp(float pxValue) {
        final float scale = mDisplayMetrics.density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     */
    public static int dp2px(float dipValue) {
        final float scale = mDisplayMetrics.density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int px2sp(float pxValue) {
        final float fontScale = mDisplayMetrics.scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    public static int sp2px(float spValue) {
        final float fontScale = mDisplayMetrics.scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 字符串转MD5
     */
    public static String MD5(String tag) {
        try {
            byte[] btInput = tag.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16)
                    sb.append("0");
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}

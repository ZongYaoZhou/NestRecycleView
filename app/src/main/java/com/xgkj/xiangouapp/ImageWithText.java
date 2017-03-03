package com.xgkj.xiangouapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xgkj.xiangouapp.tools.CustomImageView;

/**
 * Created by Administrator on 2017/2/23.
 */

public class ImageWithText extends LinearLayout implements View.OnClickListener {

    private Context context;
    private Drawable viewImage;
    private String viewText;
    private int viewTextColor;
    private float viewTextSize;
    private static TextView mTv;
    private static CustomImageView mCiv;
    private int imageType;

    public ImageWithText(Context context) {
        super(context);
    }

    public ImageWithText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.ImageWithText);
        viewImage = ta.getDrawable(R.styleable.ImageWithText_view_image);
        viewText = ta.getString(R.styleable.ImageWithText_view_text);
        viewTextColor = ta.getColor(R.styleable.ImageWithText_view_textColor,0xffcbcbcb);
        viewTextSize = ta.getDimension(R.styleable.ImageWithText_view_textSize,16);
        initView();
        ta.recycle();
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lv_shop_home,this,true);
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll_imagewithtext);
        mCiv = (CustomImageView) view.findViewById(R.id.civ_imagewithtext);
        mTv = (TextView) view.findViewById(R.id.tv_imagewithtext);
        mCiv.setImageDrawable(viewImage);

        mTv.setText(viewText);
        mTv.setTextColor(viewTextColor);
        mTv.setTextSize(viewTextSize);
        ll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context,mTv.getText(),Toast.LENGTH_SHORT).show();
    }

    public TextView getTv() {
        return this.mTv;
    }

    public CustomImageView getCiv() {
        return this.mCiv;
    }

    public int getImageType() {
        return this.imageType;
    }

    /**
     * 设置图片类型：圆形、圆角矩形、椭圆形
     * @param imageType
     */
    public void setImageType(int imageType) {
        if (imageType != imageType) {
            this.imageType = imageType;
            this.mCiv.setType(imageType);
            invalidate();
        }
    }
//    public void setText(int resId) {
//        textView.setText(resId);
//    }
//    public void setText(CharSequence buttonText) {
//        textView.setText(buttonText);
//    }
//    public void setTextColor(int color) {
//        textView.setTextColor(color);
//    }
//    public void setTextSize(int size) {
//        textView.setTextSize(size);
//    }
}

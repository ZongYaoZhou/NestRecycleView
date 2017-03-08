package com.xgkj.xiangouapp.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2017/2/23.
 */

public class GlideImageLoader extends ImageLoader {
    /**
     返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
     传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
     切记不要胡乱强转！
     --注:图片加载器可以由自己选择，这里只是提供glide使用方法
     */
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }

//    //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
//    @Override
//    public ImageView createImageView(Context context) {
//        return super.createImageView(context);
//    }
}

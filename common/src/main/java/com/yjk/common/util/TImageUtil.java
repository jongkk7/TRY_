package com.yjk.common.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yjk.common.R;

public class TImageUtil {

    public static void loadImage(Context context, ImageView imageView, Uri uri){
        Glide.with(context).load(uri).into(imageView);
    }

    public static void loadImage(Context context, ImageView imageView, String uri){
        Glide.with(context).load(uri).into(imageView);
    }

    public static void loadCircleImage(Context context, ImageView imageView, String uri){
        GradientDrawable drawable = (GradientDrawable) context.getDrawable(R.drawable.shape_circle);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);
        Glide.with(context).load(uri).into(imageView);
    }
}

package com.yjk.common.util;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TImageUtil {

    public static void loadImage(Context context, ImageView imageView, Uri uri){
        Glide.with(context).load(uri).into(imageView);
    }
}

package com.yjk.atry._2_recyclerview_viewpager.step03.datamodel;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.Objects;

public class PictureDataModel {

    private Bitmap bitmap;

    private String title; // 사진 찍힌 날짜

    private boolean isLike = false;

    public PictureDataModel(Bitmap bitmap, String title) {
        this.bitmap = bitmap;
        this.title = title;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PictureDataModel that = (PictureDataModel) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

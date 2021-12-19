package com.yjk.atry._2_recyclerview_viewpager.datamodel;

/**
 * 도전과제 1 데이터모델
 */
public class SimpleContentsDataModel {

    private String title;

    private String contents;

    public SimpleContentsDataModel(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}

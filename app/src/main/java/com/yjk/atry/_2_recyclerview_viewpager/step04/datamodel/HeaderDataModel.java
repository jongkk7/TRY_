package com.yjk.atry._2_recyclerview_viewpager.step04.datamodel;

public class HeaderDataModel implements Comparable {

    private String date;
    private String contents;

    public HeaderDataModel(String date, String contents) {
        this.date = date;
        this.contents = contents;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }


    @Override
    public int compareTo(Object o) {
        return this.date.compareTo(((HeaderDataModel)o).date);
    }
}

package com.yjk.atry._0_root.datamodel;

/**
 * 개발 이동정보 데이터모델
 */
public class ProjectDataModel {

    private int stage;
    private String title;
    private Class classInfo; // 진입 클래스

    public ProjectDataModel(int stage, String title, Class classInfo) {
        this.stage = stage;
        this.title = title;
        this.classInfo = classInfo;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(Class classInfo) {
        this.classInfo = classInfo;
    }
}

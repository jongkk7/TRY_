package com.yjk.atry._0_root.datamodel;

/**
 * 개발 이동정보 데이터모델
 */
public class ProjectDataModel {

    private String title;
    private Class classInfo; // 진입 클래스

    public ProjectDataModel(String title, Class classInfo) {
        this.title = title;
        this.classInfo = classInfo;
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

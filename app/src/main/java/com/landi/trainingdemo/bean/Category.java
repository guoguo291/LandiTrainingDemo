package com.landi.trainingdemo.bean;

/**
 * Created by guoj on 2019/7/27.
 */

public class Category {
    private int id;
    private String categoryName;
    private int getCategoryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getGetCategoryCode() {
        return getCategoryCode;
    }

    public void setGetCategoryCode(int getCategoryCode) {
        this.getCategoryCode = getCategoryCode;
    }
}

package com.landi.trainingdemo.bean;


import org.litepal.crud.LitePalSupport;

/**
 * Created by guoj on 2019/7/27.
 */

public class Book extends LitePalSupport{
    private int id;
    private String name;
    private String author;
    private int pages;
    private double price;
    private String press;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}

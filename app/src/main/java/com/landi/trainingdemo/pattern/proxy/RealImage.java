package com.landi.trainingdemo.pattern.proxy;

/**
 * Created by guoj on 2019/8/26.
 */

public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    @Override
    public String showPathInfo() {
        return "图片源路径："+fileName;
    }

    @Override
    public void setPath(String path) {

    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

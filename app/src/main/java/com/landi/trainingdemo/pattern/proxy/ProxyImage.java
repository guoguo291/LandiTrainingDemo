package com.landi.trainingdemo.pattern.proxy;

/**
 * Created by guoj on 2019/8/26.
 */

public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage==null){
            realImage=new RealImage(fileName);
        }
        realImage.display();
    }

    @Override
    public String showPathInfo() {
        if (realImage==null){
            realImage=new RealImage(fileName);
        }
        return realImage.showPathInfo();
    }

    @Override
    public void setPath(String path) {

    }
}

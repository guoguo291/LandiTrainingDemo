package com.landi.trainingdemo.pattern.absfactory;

/**
 * Created by guoj on 2019/8/23.
 */

public class ShapeFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        return null;
    }

    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

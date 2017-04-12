package com.ss.designpatterns;

import java.util.Hashtable;

/**
 * Created by Saurav on 11-04-2017.
 */
public class ProtoTypeDesignPattern {

    public static void main(String[] args) {
        ShapeCache.loadCache();
        try {
            Shape circleShape = ShapeCache.getShape(1);
            System.out.println("Shape :: " + circleShape.getType());
            Shape triangleShape = ShapeCache.getShape(2);
            System.out.println("Shape :: " + triangleShape.getType());
            Shape squareShape = ShapeCache.getShape(3);
            System.out.println("Shape :: " + squareShape.getType());
            Shape rectangleShape = ShapeCache.getShape(4);
            System.out.println("Shape :: " + rectangleShape.getType());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

abstract class Shape implements Cloneable {
    protected String type;
    private int id;

    abstract void draw();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Exception raised :: " + e);
        }
        return null;
    }
}

class Rectangle extends Shape {
    public Rectangle(int id) {
        type = "Rectangle";
        setId(id);
    }

    @Override
    void draw() {
        System.out.println("Rectangle draw()");
    }
}

class Square extends Shape {
    public Square(int id) {
        type = "Square";
        setId(id);
    }

    @Override
    void draw() {
        System.out.println("Square draw()");
    }
}

class Circle extends Shape {
    public Circle(int id) {
        type = "Circle";
        setId(id);
    }

    @Override
    void draw() {
        System.out.println("Circle draw()");
    }
}

class Triangle extends Shape {

    public Triangle(int id) {
        type = "Triangle";
        setId(id);
    }

    @Override
    void draw() {
        System.out.println("Triangle draw()");
    }
}

final class ShapeCache {
    private static final Hashtable<Integer, Shape> SHAPE_TABLE = new Hashtable<Integer, Shape>(0);

    public static Shape getShape(final Integer id) throws CloneNotSupportedException {
        Shape cachedShape = SHAPE_TABLE.get(id);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle(1);
        Triangle triangle = new Triangle(2);
        Square square = new Square(3);
        Rectangle rectangle = new Rectangle(4);

        System.out.println("============ Loading to cache =============");
        SHAPE_TABLE.put(circle.getId(), circle);
        SHAPE_TABLE.put(triangle.getId(), triangle);
        SHAPE_TABLE.put(square.getId(), square);
        SHAPE_TABLE.put(rectangle.getId(), rectangle);
        System.out.println("======== Finished Loading to cache =========");
    }
}



package com.molicode.shapes;

import java.awt.*;

public abstract class MyShape {
    private int x1; // x coordinate of first endpoint
    private int y1; // y coordinate of first endpoint
    private int x2; // x coordinate of second endpoint
    private int y2; // y coordinate of second endpoint
    private Color myColor;

    // default constructor intializes values with 0
    public MyShape() {
        this(0, 0, 0, 0, Color.BLACK);
    }

    // constructor
    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        setX1(x1);
        setY1(y1); // set y coordinate of first endpoint
        setX2(x2); // set x coordinate of second endpoint
        setY2(y2); // set y coordinate of second endpoint
        setColor(color); // set the color
    }


    public int getX1() {
        return x1;
    }

    // set the x-coordinate of the first point
    public void setX1(int x1) {
        this.x1 = (Math.max(x1, 0));
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = (Math.max(y1, 0));
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = (Math.max(x2, 0));
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = (Math.max(y2, 0));
    }

    // set the color
    public void setColor(Color color) {
        myColor = color;
    }

    // get the color
    public Color getColor() {
        return myColor;
    }

    // abstract draw method
    public abstract void draw(Graphics g);
}

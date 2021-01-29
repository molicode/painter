package com.molicode.shapes;

import java.awt.*;

public class MyLine extends MyShape {
    // call default superclass constructor
    public MyLine() {
        super();
    }

    // call superclass constructor passing parameters
    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    // draw line in specified color
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());
        graphics.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}

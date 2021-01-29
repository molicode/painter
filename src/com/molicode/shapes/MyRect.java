package com.molicode.shapes;

import java.awt.*;

public class MyRect extends MyBoundedShape {

    // call default superclass constructor
    public MyRect() {
        super();
    } // end MyRect no-argument constructor

    // call superclass constructor passing parameters
    public MyRect(int x1, int y1, int x2, int y2, Color color, boolean isFilled) {
        super(x1, y1, x2, y2, color, isFilled);
    } // end MyRect constructor

    // draw rectangle
    public void draw(Graphics graphics) {
        graphics.setColor(getColor());

        if (isFilled())
            graphics.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        else
            graphics.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }
}

package com.molicode.shapes;

import java.awt.*;

public class MyOval extends MyBoundedShape {

    // call default superclass constructor
    public MyOval() {
        super();
    }

    // call superclass constructor passing parameters
    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean isFilled) {
        super(x1, y1, x2, y2, color, isFilled);
    }

    public void draw(Graphics graphics) {
        graphics.setColor(getColor());

        if (isFilled())
            graphics.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        else
            graphics.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }
}

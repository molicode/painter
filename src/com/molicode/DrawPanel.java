package com.molicode;

import com.molicode.shapes.MyLine;
import com.molicode.shapes.MyOval;
import com.molicode.shapes.MyRect;
import com.molicode.shapes.MyShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel {

    private final MyShape[] shapes; // array containing all the shapes
    private int shapeCount; // total number of shapes

    private int shapeType; // the type of shape to draw
    private MyShape currentShape; // the type of shape to draw
    private Color currentColor; // the color of the shape
    private boolean filledShape; // whether this shape is filled

    private final JLabel statusLabel; // label displaying mouse coordinates

    // constructor
    public DrawPanel(JLabel status) {
        shapes = new MyShape[100]; // create the array
        shapeCount = 0; // initially we have no shapes

        setShapeType(0); // initially draw lines
        setDrawingColor(Color.BLACK); // start drawing with black
        setFilledShape(false);// not filled by default
        currentShape = null; // not drawing anything initially

        setBackground(Color.WHITE); // set a white background

        // add the mouse listeners
        MouseHandler mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);

        // set the status label for displaying mouse coordinates
        statusLabel = status;
    }

    // draw shapes using polymorphism
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (int i = 0; i < shapeCount; i++) {
            shapes[i].draw(graphics);
        }

        if (currentShape != null)
            currentShape.draw(graphics);
    }

    // sets the type of shape to draw
    public void setShapeType(int shapesType) {
        if (shapeType < 0 || shapesType > 2)
            shapesType = 0;

        this.shapeType = shapesType;
    }

    // sets the drawing color
    public void setDrawingColor(Color color) {
        currentColor = color;
    }

    // clears the last shape draw
    public void clearLastShape() {
        if (shapeCount > 0) {
            shapeCount--;
            repaint();
        }
    }

    // clears all drawings on this panel
    public void clearDrawing() {
        shapeCount = 0;
        repaint();
    }

    // sets whether to draw a filled shape
    public void setFilledShape(boolean isFilled) {
        filledShape = isFilled;
    }

    // handles mouse events for this JPanel
    private class MouseHandler extends MouseAdapter implements MouseMotionListener {
        // creates and sets the initial position for the new shape
        public void mousePressed(MouseEvent mouseEvent) {
            if (currentShape != null)
                return;

            // create the appropriate shape based on shapeType
            switch (shapeType) {
                case 0:
                    currentShape = new MyLine(mouseEvent.getX(), mouseEvent.getY(),
                            mouseEvent.getX(), mouseEvent.getY(), currentColor);
                    break;
                case 1:
                    currentShape = new MyOval(mouseEvent.getX(), mouseEvent.getY(),
                            mouseEvent.getX(), mouseEvent.getY(), currentColor, filledShape);
                    break;
                case 2:
                    currentShape = new MyRect(mouseEvent.getX(), mouseEvent.getY(),
                            mouseEvent.getX(), mouseEvent.getY(), currentColor, filledShape);
                    break;
            }
        }

        // fixes the current shape onto the panel
        public void mouseReleased(MouseEvent mouseEvent) {
            if (currentShape == null)
                return;

            // set the second point on the shape
            currentShape.setX2(mouseEvent.getX());
            currentShape.setY2(mouseEvent.getY());

            // set the shape only if there is room in the array
            if (shapeCount < shapes.length) {
                shapes[shapeCount] = currentShape;
                shapeCount++;
            }

            currentShape = null; // clear the temporary drawing shape
            repaint();
        }

        // update the shape to the current mouse position while dragging
        public void mouseDragged(MouseEvent mouseEvent) {
            if (currentShape != null) {
                currentShape.setX2(mouseEvent.getX());
                currentShape.setY2(mouseEvent.getY());
                repaint();
            }

            mouseMoved(mouseEvent); // update status bar
        }

        // updates the status bar to show the current mouse coordinates
        public void mouseMoved(MouseEvent mouseEvent) {
            statusLabel.setText(String.format("(%d,%d)", mouseEvent.getX(), mouseEvent.getY()));
        }
    }

}



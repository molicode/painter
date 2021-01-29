package com.molicode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DrawFrame extends JFrame implements ItemListener, ActionListener {

    // Array of possible colors
    private final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

    // Array of names corresponding to the possible colors
    private final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
            "Orange", "Pink", "Red", "White", "Yellow"};

    // Array of possible shapes
    private final String[] shapes = {"Line", "Oval", "Rectangule"};
    private final DrawPanel drawPanel; //panel that handles the drawing
    private final JButton undoButton; // button to undo the last shape drawn
    private final JButton clearButton; // button to clear all shapes
    private final JComboBox<String> colorChoices; // combo box for selecting the color
    private final JComboBox<String> shapeChoices; // combo box for selecting shapes
    private final JCheckBox filledCheckBox; // check box to toggle filled shapes

    // constructor
    public DrawFrame() {
        super("Painter");

        // create a panel to store the components at the top of the frame
        JPanel topPanel = new JPanel();

        // create a combobox for choosing colors
        colorChoices = new JComboBox<>(colorNames);
        colorChoices.addItemListener(this);
        topPanel.add(colorChoices);

        // create a combobox for chosing shapes
        shapeChoices = new JComboBox<>(shapes);
        shapeChoices.addItemListener(this);
        topPanel.add(shapeChoices);

        // create a checkbox to determine whether the shape is filled
        filledCheckBox = new JCheckBox("Filled");
        filledCheckBox.addItemListener(this);
        topPanel.add(filledCheckBox);

        // create a button for clearing the las drawing
        undoButton = new JButton("Undo");
        undoButton.addActionListener(this);
        topPanel.add(undoButton);

        // create a button for clearing all drawings
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        topPanel.add(clearButton);

        // add the top panel to the frame
        add(topPanel, BorderLayout.NORTH);

        // create a label for the status bar
        // label for the status bar
        JLabel statusLabel = new JLabel("(0,0)");

        // add the status bar at the bottom
        add(statusLabel, BorderLayout.SOUTH);

        // create the DrawPanel with  its status bar label
        drawPanel = new DrawPanel(statusLabel);

        // add the drawing area to the center
        add(drawPanel);

    }

    // handle selections made to a combobox or checkbox
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getSource() == shapeChoices) // chosing a shape
            drawPanel.setShapeType(shapeChoices.getSelectedIndex());
        else if (itemEvent.getSource() == colorChoices) // chosing a color
            drawPanel.setDrawingColor(colors[colorChoices.getSelectedIndex()]);
        else if (itemEvent.getSource() == filledCheckBox) // filed/unfilled
            drawPanel.setFilledShape(filledCheckBox.isSelected());
    }

    // handle button clicks
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == undoButton)
            drawPanel.clearLastShape();
        else if (actionEvent.getSource() == clearButton)
            drawPanel.clearDrawing();
    }

}

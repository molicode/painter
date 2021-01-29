package com.molicode;

import javax.swing.*;

public class Painter {

    public static void main(String[] args) {
        DrawFrame application = new DrawFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(500, 400);
        application.setVisible(true);
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public void build(){
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        DrawingPanel panel = new DrawingPanel(600,600);
        getContentPane().add(BorderLayout.CENTER, panel);
        pack();
        panel.setFocusable(true);
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel implements KeyListener, MouseMotionListener {
    private final RunningButton runningButton;
    private Shape shape;
    private Point point;
    public List<Shape> shapes = new ArrayList<>();


    public DrawingPanel(int width, int height){
        super();
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        addKeyListener(this);
        addMouseMotionListener(this);
        runningButton = new RunningButton(width);
        runningButton.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                runningButton.escape();
                repaint();
            }
        });


        JButton resetButton = new JButton();
        resetButton.setBounds(width-150,  height-100,100,50);
        resetButton.setText("Reset");
        resetButton.addActionListener(e -> {
            runningButton.reset();
            shapes.clear();
            repaint();
            requestFocus();
        });



        add(runningButton);
        add(resetButton);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (shapes.isEmpty() || shape == null) return;
        Graphics2D g2d = (Graphics2D) g;
        for (Shape shape : shapes){
            g2d.draw(shape);
        }
        shape = null;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (point == null) return;
        switch (e.getKeyCode()){
            case KeyEvent.VK_K:
                shape = new Rectangle2D.Float(point.x, point.y, 60f,60f);
                shapes.add(shape);
                repaint();
                break;
            case  KeyEvent.VK_O:
                shape = new Ellipse2D.Float(point.x, point.y , 60f, 50f);
                shapes.add(shape);
                repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        point = e.getPoint();
        int safeDistance = 20;
        Rectangle bounds = runningButton.getBounds();
        Rectangle safeArea = new Rectangle(
                bounds.x - safeDistance,
                bounds.y - safeDistance,
                bounds.width + 2 * safeDistance,
                bounds.height + 2 * safeDistance
        );
        if (safeArea.contains(point)){
            runningButton.escape();
            repaint();
        }

    }
    private static class RunningButton extends JButton{
        private final int buttonWidth = 100;
        private final int buttonHeight = 50;
        private final int yPosition = buttonHeight;
        private final int panelWidth;



        private RunningButton(int panelWidth){
            super();
            this.panelWidth = panelWidth;
            setText("Try to click me!");
            reset();
        }
        private void escape(){
            Random random = new Random();

            int x = random.nextInt(panelWidth - 100);
            int y = random.nextInt(panelWidth - 100);
            setBounds(x,y,buttonWidth,buttonHeight);


        }
        public void reset(){
            setBounds(50,yPosition, buttonWidth, buttonHeight);
        }
    }
}


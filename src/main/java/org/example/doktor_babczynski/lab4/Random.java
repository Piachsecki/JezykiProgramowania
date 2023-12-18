package org.example.doktor_babczynski.lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Random extends JPanel {

        private Rectangle rectangle;
        private int offsetX, offsetY;

        public Random() {
            rectangle = new Rectangle(50, 50, 100, 60);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (rectangle.contains(e.getPoint())) {
                        offsetX = e.getX() - rectangle.x;
                        offsetY = e.getY() - rectangle.y;
                    }
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (rectangle.contains(e.getPoint())) {
                        rectangle.setLocation(e.getX() - offsetX, e.getY() - offsetY);
                        repaint();
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLUE);
            g2d.fill(rectangle);
        }
    }




package org.example.doktor_babczynski.lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.List;

class PaintPanel extends JPanel {
    private int lastX, lastY;
    private Color currentColor;
    private List<ShapeWithColor> shapes;
    private BufferedImage bufferImage;

    public void changeAllColors(Color newColor) {
        for (ShapeWithColor shapeWithColor : shapes) {
            shapeWithColor.setColor(newColor);
        }
        repaint();
    }

    public PaintPanel() {
        currentColor = Color.BLACK;
        shapes = new ArrayList<>();


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                Shape shape = new Line2D.Double(lastX, lastY, x, y);
                shapes.add(new ShapeWithColor(shape, currentColor));

                lastX = x;
                lastY = y;

                repaint();
            }
        });


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (bufferImage == null) {
            bufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        }

        Graphics2D bufferGraphics = (Graphics2D) bufferImage.getGraphics();

        for (ShapeWithColor shapeWithColor : shapes) {
            bufferGraphics.setColor(shapeWithColor.getColor());
            bufferGraphics.draw(shapeWithColor.getShape());
        }

        g.drawImage(bufferImage, 0, 0, null);
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public Color getCurrentColor() {
        return currentColor;
    }


    /*
    http://www.java2s.com/Code/Java/2D-Graphics-GUI/BlurringaBufferedImage.htm -> stad wzialem funkcje blurr
     */
    public void applyBlur() {
        if (bufferImage != null) {
            // Create a Gaussian blur filter
            float[] blurMatrix = {
                    1f / 9f, 1f / 9f, 1f / 9f,
                    1f / 9f, 1f / 9f, 1f / 9f,
                    1f / 9f, 1f / 9f, 1f / 9f
            };
            Kernel blurKernel = new Kernel(3, 3, blurMatrix);
            ConvolveOp blurOp = new ConvolveOp(blurKernel);
            bufferImage = blurOp.filter(bufferImage, null);

            repaint();
        }
    }

    private static class ShapeWithColor {
        private final Shape shape;
        private Color color;

        public ShapeWithColor(Shape shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public Shape getShape() {
            return shape;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }
}
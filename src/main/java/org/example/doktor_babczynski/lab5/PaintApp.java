package org.example.doktor_babczynski.lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintApp {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Paint Application");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PaintPanel paintPanel = new PaintPanel();
            frame.add(paintPanel, BorderLayout.CENTER);


            JButton colorChangeToBlueButton = new JButton("Change Color to blue");
            colorChangeToBlueButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ColorChangeWorker(paintPanel, Color.BLUE);
                }
            });
            JButton colorChangeToBlackButton = new JButton("Change Color to black");
            colorChangeToBlackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ColorChangeWorker(paintPanel, Color.BLACK);
                }
            });

            JButton colorChangeToGreenButton = new JButton("Change Color to green");
            colorChangeToGreenButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ColorChangeWorker(paintPanel, Color.GREEN);
                }
            });


            JButton blurButton = new JButton("Apply Blur");
            blurButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Execute blur in a separate thread
                    new BlurWorker(paintPanel);
                }
            });

            JButton changeAllColorsButton = new JButton("Change All Colors to Red");
            changeAllColorsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        new ChangeAllColorsWorker(paintPanel, Color.RED);

                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(colorChangeToBlueButton);
            buttonPanel.add(colorChangeToBlackButton);
            buttonPanel.add(colorChangeToGreenButton);
            buttonPanel.add(blurButton);
            buttonPanel.add(changeAllColorsButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}









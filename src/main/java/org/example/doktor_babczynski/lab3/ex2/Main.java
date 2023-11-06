package org.example.doktor_babczynski.lab3.ex2;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Label Order Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a main panel with a BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        // Create a top panel with a FlowLayout for the top 3 labels
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Label 1"));
        topPanel.add(new JLabel("Label 2"));
        topPanel.add(new JLabel("Label 3"));

        // Create a center panel with a single label in the center
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Vertical alignment
        centerPanel.add(Box.createVerticalGlue()); // Pushes the label to the center
        centerPanel.add(new JLabel("Label 4"));
        centerPanel.add(Box.createVerticalGlue()); // Pushes the label to the center

        // Create a bottom panel with a FlowLayout for the bottom 2 labels
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(new JLabel("Label 5"));
        bottomPanel.add(new JLabel("Label 6"));

        // Create an end panel with a FlowLayout for the end 2 labels
        JPanel endPanel = new JPanel(new FlowLayout());
        endPanel.add(new JLabel("Label 7"));
        endPanel.add(new JLabel("Label 8"));

        // Add the panels to the main panel in the desired order
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);
        mainPanel.add(endPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

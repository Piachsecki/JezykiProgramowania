package org.example.doktor_babczynski.lab4;

import javax.swing.*;

public class MoveObjectOnCanvas {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Move Object On Canvas");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Random random = new Random();
                frame.add(random);

                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        }
    }
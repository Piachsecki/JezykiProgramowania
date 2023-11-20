package org.example.doktor_babczynski.lab3.ex3;

import javax.swing.*;
import java.awt.*;

public class MyFrame3 extends JFrame {
    private JOptionPane optionPane = new JOptionPane();
    private JTextField textField;
    public MyFrame3() {
        this.setSize( 500, 500);
        this.setName("Exercise 3.");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        textField = new JTextField();
        String name = JOptionPane.showInputDialog("Enter your name: ");
        textField.setText(name);

        JOptionPane.showMessageDialog(this, String.format("Hello %s", name));

        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}

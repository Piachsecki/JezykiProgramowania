package org.example.doktor_babczynski.lab3.ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordStrengthChecker extends JFrame implements ActionListener {

    private JTextField passwordField;

    public PasswordStrengthChecker() {

        setTitle("Password Strength Checker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JTextField();
        JButton checkButton = new JButton("Check Strength");

        setLayout(new GridLayout(3, 1));

        add(passwordLabel);
        add(passwordField);
        add(checkButton);

        checkButton.addActionListener(this);

    }

    private void checkPasswordStrength() {
        String password = passwordField.getText();

        int length = password.length();
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        boolean hasDigits = password.matches(".*\\d.*");
        String[] specialButtons = new String[]{"!", "@", "#", "$", "%", "&", "*", "?"};
        boolean hasSpecialSign = true;
        for (String specialButton : specialButtons) {
            if (!password.contains(specialButton)){
                hasSpecialSign = false;
            }
            break;
        }

        int strength = 0;
        if (length >= 8) {
            strength++;
        }
        if (hasUpperCase) {
            strength++;
        }
        if (hasLowerCase) {
            strength++;
        }
        if (hasDigits) {
            strength++;
        }
        if(hasSpecialSign){
            strength++;
        }

        String resultMessage = "Password Strength: " + strength + "/5";
        JOptionPane.showMessageDialog(this, resultMessage, "Result", JOptionPane.INFORMATION_MESSAGE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        checkPasswordStrength();
    }
}

package org.example.doktor_babczynski.lab3.ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame1 extends JFrame implements ActionListener {
    private JPanel jPanel = new JPanel();
    private JLabel name;
    private JLabel surname;
    private JPasswordField password;
    private JButton button;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextArea showPassword;
    private JTextArea showName;
    private JTextArea showSurname;

    public MyFrame1() {


        name = new JLabel("Name : ");
        surname = new JLabel("Surname: ");
        password = new JPasswordField("Password: ");
        button = new JButton("Submit");
        button.addActionListener(this);
        jTextField1 = new JTextField(20);
        jTextField2 = new JTextField(20);
        showName = new JTextArea();
        showSurname = new JTextArea();
        showPassword = new JTextArea();

        jPanel.add(name, BorderLayout.NORTH);
        jPanel.add(jTextField1, BorderLayout.NORTH);
        jPanel.add(surname, BorderLayout.NORTH);
        jPanel.add(jTextField2, BorderLayout.NORTH);
        jPanel.add(password, BorderLayout.NORTH);
        jPanel.add(button, BorderLayout.CENTER);
        jPanel.add(showName, BorderLayout.EAST);
        jPanel.add(showSurname, BorderLayout.EAST);
        jPanel.add(showPassword, BorderLayout.EAST);


        this.add(jPanel);

        this.setName("Exercise 1.");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("working");
            String text = jTextField1.getText();
            showName.setText(text);
            String text1 = jTextField2.getText();
            showSurname.setText(text1);
            showPassword.setText(String.valueOf(password.getPassword()));
//            jPanel.add(showName, BorderLayout.SOUTH);
//            jPanel.add(showSurname, BorderLayout.SOUTH );
//            jPanel.add(showPassword,  BorderLayout.SOUTH);
        }
    }
}

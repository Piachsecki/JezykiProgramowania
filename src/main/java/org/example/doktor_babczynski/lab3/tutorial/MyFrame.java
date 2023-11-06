package org.example.doktor_babczynski.lab3.tutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private JPanel jPanel = new JPanel(new FlowLayout());
    private JLabel name;
    private JLabel surname;
    private JPasswordField password;
    private JButton button;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextArea showPassword;
    private JTextArea showName;
    private JTextArea showSurname;

    public MyFrame() {


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

        jPanel.add(name);
        jPanel.add(jTextField1);
        jPanel.add(surname);
        jPanel.add(jTextField2);
        jPanel.add(password);
        jPanel.add(button);
        jPanel.add(showName);
        jPanel.add(showSurname);
        jPanel.add(showPassword);


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
            showName.setText(text1);
            showName.setText(String.valueOf(password.getPassword()));
//            jPanel.add(showName, BorderLayout.SOUTH);
//            jPanel.add(showSurname, BorderLayout.SOUTH );
//            jPanel.add(showPassword,  BorderLayout.SOUTH);
        }
    }
}

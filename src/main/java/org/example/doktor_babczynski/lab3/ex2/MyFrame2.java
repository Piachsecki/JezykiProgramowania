package org.example.doktor_babczynski.lab3.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame implements ActionListener {
    private JPanel mainPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();

    private JLabel name;
    private JLabel surname;
    private JPasswordField password;
    private JButton buttonNorth;

    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextArea showPassword;
    private JTextArea showName;
    private JTextArea showSurname;
    public MyFrame2() {
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        name = new JLabel("Name : ");
        surname = new JLabel("Surname: ");
        password = new JPasswordField("Password: ");
        buttonNorth = new JButton("Submit");
        buttonNorth.addActionListener(this);
        jTextField1 = new JTextField(20);
        jTextField2 = new JTextField(20);
        showName = new JTextArea();
        showSurname = new JTextArea();
        showPassword = new JTextArea();


        topPanel.add(name, BorderLayout.NORTH);
        topPanel.add(surname, BorderLayout.NORTH);
        topPanel.add(password, BorderLayout.NORTH);



        mainPanel.add(topPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(southPanel);



        this.add(mainPanel);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

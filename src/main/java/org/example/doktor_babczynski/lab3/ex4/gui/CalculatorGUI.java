package org.example.doktor_babczynski.lab3.ex4.gui;

import org.example.doktor_babczynski.lab3.ex4.constants.CommonConstants;
import org.example.doktor_babczynski.lab3.ex4.service.CalculationService;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.doktor_babczynski.lab3.ex4.constants.CommonConstants.BUTTON_COUNT;
import static org.example.doktor_babczynski.lab3.ex4.constants.CommonConstants.TEXT_FIELD_LENGTH;

public class CalculatorGUI extends JFrame implements ActionListener {
    private final SpringLayout springLayout = new SpringLayout();
    private JTextField displayField;
    private CalculationService calculationService;

    private JButton[] buttons;

    private boolean pressedOperator = false;
    private boolean pressedEquals = false;
    public CalculatorGUI(){
        super(CommonConstants.APP_NAME);
        setSize(CommonConstants.WIDTH,CommonConstants.HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(springLayout);
        calculationService = new CalculationService();
//        setVisible(true);

        addGuiComponents();
    }

    public void addGuiComponents(){
        addDisplayFields();
        addButtons();

    }

    private void addButtons() {
        GridLayout gridLayout =
                new GridLayout(
                        CommonConstants.BUTTON_ROW_COUNT,
                        CommonConstants.BUTTON_COLUMN_COUNT
                );
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(gridLayout);
        buttons = new JButton[BUTTON_COUNT];
        for (int i = 0; i < BUTTON_COUNT; i++) {
            JButton jButton = new JButton(getButtonLabel(i));
            jButton.addActionListener(this);

            buttonPanel.add(jButton);

        }

        gridLayout.setHgap(CommonConstants.BUTTON_HGAP);
        gridLayout.setVgap(CommonConstants.BUTTON_VGAP);

        this.getContentPane().add(buttonPanel);
        springLayout.putConstraint(SpringLayout.NORTH, buttonPanel, CommonConstants.BUTTON_SPRING_LAYOUT_NORTH_PAD, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, buttonPanel, CommonConstants.BUTTON_SPRING_LAYOUT_WEST_PAD, SpringLayout.WEST, this);

    }

    private String getButtonLabel(int buttonIndex) {

        switch (buttonIndex){
            case 0:
                return "7";
            case 1:
                return "8";
            case 2:
                return "9";
            case 3:
                return "/";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "x";
            case 8:
                return "1";
            case 9:
                return "2";
            case 10:
                return "3";
            case 11:
                return "-";
            case 12:
                return "0";
            case 13:
                return ".";
            case 14:
                return "+";
            case 15:
                return "=";
        }
        return "";
    }

    private void addDisplayFields() {
        JPanel displayFieldPanel = new JPanel();
        displayField = new JTextField(TEXT_FIELD_LENGTH);
        displayField.setEditable(false);
        displayField.setText("0");
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);

        displayFieldPanel.add(displayField);

        this.getContentPane().add(displayFieldPanel);
        springLayout.putConstraint(SpringLayout.NORTH, displayFieldPanel, CommonConstants.TEXT_FIELD_SPRING_LAYOUT_NORTH_PAD, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, displayFieldPanel, CommonConstants.TEXT_FIELD_SPRING_LAYOUT_WEST_PAD, SpringLayout.WEST, this);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonCommand = e.getActionCommand();
        if(buttonCommand.matches("[0-9]")){
            if(pressedEquals || pressedOperator || displayField.getText().equals("0"))
                displayField.setText(buttonCommand);
            else
                displayField.setText(displayField.getText() + buttonCommand);

            // update flags
            pressedOperator = false;
            pressedEquals = false;
        }else if(buttonCommand.equals("=")){
            // calculate
            calculationService.setNum2(Double.parseDouble(displayField.getText()));

            double result = 0;
            switch(calculationService.getMathematicalSymbol()){
                case '+':
                    result = calculationService.add();
                    break;
                case '-':
                    result = calculationService.subtract();
                    break;
                case '/':
                    result = calculationService.divide();
                    break;
                case 'x':
                    result = calculationService.multiply();
                    break;
            }

            // update the display field
            displayField.setText(Double.toString(result));

            // update flags
            pressedEquals = true;
            pressedOperator = false;

        }else if(buttonCommand.equals(".")){
            if(!displayField.getText().contains(".")){
                displayField.setText(displayField.getText() + buttonCommand);
            }
        }else{ // operator
            if(!pressedOperator)
                calculationService.setNum1(Double.parseDouble(displayField.getText()));

            calculationService.setMathematicalSymbol(buttonCommand.charAt(0));

            // update flags
            pressedOperator = true;
            pressedEquals = false;
        }
    }
}

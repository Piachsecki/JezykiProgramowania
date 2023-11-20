package org.example.doktor_babczynski.lab3.ex4;


import org.example.doktor_babczynski.lab3.ex4.gui.CalculatorGUI;

// Stwórz prosty interfejs kalkulatora, który zawiera przyciski z cyframi
// i podstawowymi operacjami (dodawanie, odejmowanie, mnożenie, dzielenie).
// Pozwól użytkownikom wykonywać obliczenia i
// wyświetlać wyniki w polu JTextField lub JLabel.
// Upewnij się, że elementy GUI są odpowiednio dostosowane
// pod względem rozmiaru
// i pozycji.
public class Main {

    public static void main(String[] args) {
        new CalculatorGUI().setVisible(true);

    }
}

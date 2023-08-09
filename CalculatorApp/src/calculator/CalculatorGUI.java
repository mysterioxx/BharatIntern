package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;
    private JPanel panel;

    private double num1, num2, result;
    private char operator;

    public CalculatorGUI() {
        // Initialize frame and components
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        inputField = new JTextField();
        inputField.setBounds(30, 30, 240, 40);
        add(inputField);

        // Initialize number buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Initialize operation buttons
        operationButtons = new JButton[4];
        String[] operationSymbols = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            operationButtons[i] = new JButton(operationSymbols[i]);
            operationButtons[i].addActionListener(this);
        }

        // Initialize other buttons
        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        clearButton = new JButton("C");
        clearButton.addActionListener(this);

        // Create panel and add buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBounds(30, 100, 240, 240);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(operationButtons[0]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(operationButtons[1]);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(operationButtons[2]);
        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(operationButtons[3]);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source instanceof JButton) {
            JButton clickedButton = (JButton) source;
            String buttonText = clickedButton.getText();

            if (Character.isDigit(buttonText.charAt(0))) {
                inputField.setText(inputField.getText() + buttonText);
            } else if (buttonText.matches("[+\\-*/]")) {
                num1 = Double.parseDouble(inputField.getText());
                operator = buttonText.charAt(0);
                inputField.setText("");
            } else if (buttonText.equals("=")) {
                num2 = Double.parseDouble(inputField.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                inputField.setText(String.valueOf(result));
            } else if (buttonText.equals("C")) {
                inputField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI());
    }
}

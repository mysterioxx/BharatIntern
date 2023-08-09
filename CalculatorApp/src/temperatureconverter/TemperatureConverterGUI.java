package temperatureconverter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton convertButton;

    public TemperatureConverterGUI() {
        // Initialize frame and components
        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputField = new JTextField(10);
        resultLabel = new JLabel("Converted: ");
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        add(new JLabel("Enter Temperature (Celsius): "));
        add(inputField);
        add(resultLabel);
        add(convertButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            try {
                double celsius = Double.parseDouble(inputField.getText());
                double fahrenheit = celsiusToFahrenheit(celsius);
                resultLabel.setText("Converted: " + fahrenheit + " °F");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            }
        }
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverterGUI());
    }
}

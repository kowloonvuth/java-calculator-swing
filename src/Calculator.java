import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberField = new JTextField(10);

        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberField = new JTextField(10);

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(10);
        resultField.setEditable(false);

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton clearButton = new JButton("Clear");


        addButton.addActionListener(new OperationListener("+"));
        subtractButton.addActionListener(new OperationListener("-"));
        multiplyButton.addActionListener(new OperationListener("*"));
        divideButton.addActionListener(new OperationListener("/"));
        clearButton.addActionListener(e -> clearFields());


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(firstNumberLabel);
        panel.add(firstNumberField);
        panel.add(secondNumberLabel);
        panel.add(secondNumberField);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(clearButton);

        add(panel);

        setVisible(true);
    }

    private void clearFields() {
        firstNumberField.setText("");
        secondNumberField.setText("");
        resultField.setText("");
    }

    private class OperationListener implements ActionListener {
        private String operation;

        public OperationListener(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double firstNumber = Double.parseDouble(firstNumberField.getText());
                double secondNumber = Double.parseDouble(secondNumberField.getText());
                double result = 0;

                switch (operation) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                }

                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Calculator.this, "Invalid input. Please enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(Calculator.this, "Error in calculation.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}

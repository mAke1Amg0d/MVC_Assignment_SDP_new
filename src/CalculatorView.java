import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JTextField firstNumber = new JTextField(10);
    private JTextField secondNumber = new JTextField(10);
    private JTextField result = new JTextField(20);
    JButton addButton = new JButton("+");
    JButton subtractButton = new JButton("-");
    JButton multiplyButton = new JButton("*");
    JButton divideButton = new JButton("/");

    public CalculatorView() {
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        calcPanel.add(new JLabel("Число 1:"));
        calcPanel.add(firstNumber);
        calcPanel.add(new JLabel("Число 2:"));
        calcPanel.add(secondNumber);
        calcPanel.add(addButton);
        calcPanel.add(subtractButton);
        calcPanel.add(multiplyButton);
        calcPanel.add(divideButton);
        calcPanel.add(new JLabel("Результат:"));
        calcPanel.add(result);

        result.setEditable(false);

        this.add(calcPanel);
    }

    public double getFirstNumber() throws NumberFormatException {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber() throws NumberFormatException {
        return Double.parseDouble(secondNumber.getText());
    }

    public void setResult(String resultText) {
        result.setText(resultText);
    }

    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
    }
}
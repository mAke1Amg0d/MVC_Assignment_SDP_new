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
        // Set layout and background color
        JPanel calcPanel = new JPanel(new GridBagLayout());
        calcPanel.setBackground(new Color(240, 240, 240));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Калькулятор");
        this.setSize(400, 200);

        // Configure text fields and result area
        result.setEditable(false);
        result.setBackground(new Color(230, 230, 230));

        // Add first number label and text field
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        calcPanel.add(new JLabel("Число 1:"), c);

        c.gridx = 1;
        calcPanel.add(firstNumber, c);

        // Add second number label and text field
        c.gridx = 0;
        c.gridy = 1;
        calcPanel.add(new JLabel("Число 2:"), c);

        c.gridx = 1;
        calcPanel.add(secondNumber, c);

        // Add buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        calcPanel.add(buttonPanel, c);

        // Add result label and text field
        c.gridx = 0;
        c.gridy = 3;
        calcPanel.add(new JLabel("Результат:"), c);

        c.gridx = 1;
        calcPanel.add(result, c);

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
        this.view.addOperationListener(new OperationListener());
    }

    class OperationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double firstNumber = view.getFirstNumber();
                double secondNumber = view.getSecondNumber();
                double result = 0;

                if (e.getSource() == view.addButton) {
                    result = model.add(firstNumber, secondNumber);
                } else if (e.getSource() == view.subtractButton) {
                    result = model.subtract(firstNumber, secondNumber);
                } else if (e.getSource() == view.multiplyButton) {
                    result = model.multiply(firstNumber, secondNumber);
                } else if (e.getSource() == view.divideButton) {
                    result = model.divide(firstNumber, secondNumber);
                }

                view.setResult(String.valueOf(result));
            } catch (ArithmeticException ae) {
                view.setResult(ae.getMessage());
            } catch (NumberFormatException nfe) {
                view.setResult("Ошибка: введите правильные числа");
            }
        }
    }
}
package ic.doc;

import javax.swing.*;

public class CalculatorFrontEnd {

  private final int textFieldSize = 10;
  private final int frameWidth = 400;
  private final int frameheight = 300;

  private final CalculatorBackEnd model = new CalculatorBackEnd();

  private void addDigit(JPanel panel, JTextField textField, final int digit) {
    if (digit < 0 || digit > 9) {
      throw new IllegalArgumentException(digit + "is not a digit.");
    }
    JButton button = new JButton(Integer.toString(digit));
    panel.add(button);
    button.addActionListener(e -> textField.setText(textField.getText() + digit));
  }

  private void addDigits(JPanel panel, JTextField textField) {
    for (int i = 1; i <= 9; i++) {
      addDigit(panel, textField, i);
    }
    addDigit(panel, textField, 0);
  }

  private void addEnter(JPanel panel, JTextField textField) {
    JButton enter = new JButton("Enter");
    panel.add(enter);
    enter.addActionListener(
        e -> {
          if (textField.getText().length() > 0) {
            model.pushToStack(Double.parseDouble(textField.getText()));
            textField.setText("");
          }
        });
  }

  private void addBackspace(JPanel panel, JTextField textField) {
    JButton backspace = new JButton("Backspace");
    panel.add(backspace);
    backspace.addActionListener(
        e -> {
          String text = textField.getText();
          if (text.length() > 0) {
            textField.setText(text.substring(0, text.length() - 1));
          }
        });
  }

  private void addOperator(JPanel panel, JTextField textField, final char op) {
    JButton sub = new JButton(String.valueOf(op));
    panel.add(sub);
    sub.addActionListener(e -> {
      try {
        textField.setText(Double.toString(model.executeOperation(op)));
      } catch (ArithmeticException ignored) {}
    });
  }

  private void addOperators(JPanel panel, JTextField textField) {
    for (char op : "+-/*".toCharArray()) {
      addOperator(panel, textField, op);
    }
  }

  private void display() {
    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(frameWidth, frameheight);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    JTextField textField = new JTextField(textFieldSize);

    addDigits(panel, textField);
    addOperators(panel, textField);
    addEnter(panel, textField);
    addBackspace(panel, textField);

    panel.add(textField);
    frame.add(panel);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new CalculatorFrontEnd().display();
  }
}

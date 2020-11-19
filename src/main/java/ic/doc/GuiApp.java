package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiApp {

  private final Calculator calculator;
  private final View view;

  public GuiApp() {
    this.calculator = new Calculator();
    this.view = new View(new Controller());
  }

  private class Controller implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      perform(e.getActionCommand());
    }

    public void perform(String action) {
      JTextField textField = view.getTextField();

      if ("+-*/".contains(action)) {
        if (calculator.canDoOp()) {
          switch (action) {
            case "+":
              calculator.add();
              break;
            case "-":
              calculator.sub();
              break;
            case "*":
              calculator.mul();
              break;
            case "/":
              calculator.div();
              break;
            default:
              break;
          }
          view.update(calculator);
        }
      } else {
        switch (action) {
          case "Push":
            calculator.pushToStack(Double.parseDouble(textField.getText()));
            textField.setText("");
          case "Clear":
            textField.setText("");
            break;
          default:
            textField.setText(textField.getText() + action);
        }
      }
    }
  }

  public static void main(String[] args) {
    new GuiApp();
  }
}

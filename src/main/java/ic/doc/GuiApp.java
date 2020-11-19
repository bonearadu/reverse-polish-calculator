package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class GuiApp {

  private final BackEnd backEnd;
  private final View view;

  public GuiApp() {
    this.backEnd = new BackEnd();
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
        switch (action) {
          case "+":
            backEnd.add();
            break;
          case "-":
            backEnd.sub();
            break;
          case "*":
            backEnd.mul();
            break;
          case "/":
            backEnd.div();
            break;
          default:
            break;
        }
        backEnd.setText(backEnd.peekStack().toString());
      } else {
        switch (action) {
          case "Push":
            backEnd.pushToStack(Double.parseDouble(textField.getText()));
            backEnd.setText("");
            break;
          case "Clear":
            backEnd.setText("");
            break;
          default:
            backEnd.setText(textField.getText() + action);
        }
      }
      view.update(backEnd);
    }
  }

  public static void main(String[] args) {
    new GuiApp();
  }
}

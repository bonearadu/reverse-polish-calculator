package ic.doc;

import javax.swing.*;

public class GuiApp {

  public static void main(String[] args) {
    new GuiApp().display();
  }

  private void display() {

    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(400, 300);

    JPanel panel = new JPanel();
    JTextField textField = new JTextField("0");
    textField.setColumns(10);

    for (int i = 1; i <= 4; i++) {
      JButton button = new JButton(Integer.toString(i));
      panel.add(button);
      int finalI = i;
      button.addActionListener(
          e -> textField.setText(Integer.toString(finalI)));
    }

    JButton plus = new JButton("+");
    panel.add(plus);

    JButton sub = new JButton("-");
    panel.add(sub);

    panel.add(textField);

    frame.add(panel);
    frame.setVisible(true);
  }
}

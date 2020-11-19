package ic.doc;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class View implements Updatable {

  private final int textFieldSize = 10;
  private final int frameWidth = 400;
  private final int frameheight = 300;

  public final JTextField textField;

  public View(ActionListener controller) {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    textField = new JTextField(textFieldSize);
    frame.setSize(frameWidth, frameheight);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    List<JButton> buttons = createButtons();
    for (JButton button : buttons) {
      button.addActionListener(controller);
      panel.add(button);
    }

    panel.add(textField);
    frame.add(panel);
    frame.setVisible(true);
  }

  public JTextField getTextField() {
    return textField;
  }

  public void update (Calculator calculator) {
    textField.setText(calculator.peekStack());
  }

  private List<JButton> createButtons() {
    List <JButton> buttons = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
      buttons.add(new JButton(String.valueOf(i)));
    }
    buttons.add(new JButton(String.valueOf(0)));
    buttons.add(new JButton("+"));
    buttons.add(new JButton("-"));
    buttons.add(new JButton("*"));
    buttons.add(new JButton("/"));
    buttons.add(new JButton("Clear"));
    buttons.add(new JButton("Push"));
    return buttons;
  }
}

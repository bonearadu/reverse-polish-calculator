package ic.doc;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/* View component of the Reverse Polish Calculator app. */
public class View implements Updatable {

  private final int textFieldSize = 10;
  private final int frameWidth = 150;
  private final int frameHeight = 250;

  public final JTextField textField;

  /* Initializes frame and panel, populates them with buttons
   * and the text field and displays the frame when finished. */
  public View(ActionListener controller) {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    textField = new JTextField(textFieldSize);
    frame.setSize(frameWidth, frameHeight);
    frame.setResizable(false);
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

  /* Creates buttons for digits, operations,
   * clearing the text field and pushing to stack. */
  private List<JButton> createButtons() {
    List<JButton> buttons = new ArrayList<>();
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

  public JTextField getTextField() {
    return textField;
  }

  /* Sets the value of the text field to the one specified by the back end. */
  public void update(BackEnd backEnd) {
    textField.setText(backEnd.getText());
  }
}

package ic.doc;

import java.util.Stack;

public class BackEnd {

  Stack<Integer> values = new Stack<>();

  public void pushToStack(int value) {
    values.push(value);
  }

  public int executeOperation(char symbol) {
    if (values.size() == 0) {
      return 0;
    }

    if (values.size() > 1) {
      switch (symbol) {
        case '+':
          add();
          break;
        case '-':
          sub();
          break;
        default:
          throw new UnsupportedOperationException("Unsupported '" + symbol + "' operation.");
      }
    }

    return values.peek();
  }

  private void add() {
    values.push(values.pop() + values.pop());
  }

  private void sub() {
    values.push(values.pop() - values.pop());
  }
}
package ic.doc;

import java.util.Stack;

public class CalculatorBackEnd {

  Stack<Double> values = new Stack<>();

  public void pushToStack(double value) {
    values.push(value);
  }

  public double executeOperation(char symbol) {
    if (values.size() == 0) {
      throw new ArithmeticException();
    }

    if (values.size() > 1) {
      switch (symbol) {
        case '+':
          add();
          break;
        case '-':
          sub();
          break;
        case '*':
          mul();
          break;
        case '/':
          div();
          break;
        default:
          throw new UnsupportedOperationException("Unsupported operation: " + symbol);
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

  private void mul() {
    values.push(values.pop() * values.pop());
  }

  private void div() {
    values.push(values.pop() / values.pop());
  }
}
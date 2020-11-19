package ic.doc;

import java.util.Stack;

public class Calculator {

  private final Stack<Double> values = new Stack<>();

  public Calculator() {
  }

  public String peekStack() {
    return values.peek().toString();
  }

  public void pushToStack(double value) {
    values.push(value);
  }

  public boolean canDoOp() {
    return values.size() > 1;
  }

  public void add() {
    values.push(values.pop() + values.pop());
  }

  public void sub() {
    values.push(values.pop() - values.pop());
  }

  public void mul() {
    values.push(values.pop() * values.pop());
  }

  public void div() {
    values.push(values.pop() / values.pop());
  }
}
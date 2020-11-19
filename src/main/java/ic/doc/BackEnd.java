package ic.doc;

import java.util.Stack;

public class BackEnd {

  private final Stack<Double> values = new Stack<>();
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void pushToStack(double value) {
    values.push(value);
  }

  public boolean canDoOp() {
    return values.size() > 1;
  }

  public void add() {
    if (canDoOp()) {
      values.push(values.pop() + values.pop());
    }
  }

  public void sub() {
    if (canDoOp()) {
      Double snd = values.pop();
      Double fst = values.pop();
      values.push(fst - snd);
    }
  }

  public void mul() {
    if (canDoOp()) {
      values.push(values.pop() * values.pop());
    }
  }

  public void div() {
    if (canDoOp()) {
      Double snd = values.pop();
      Double fst = values.pop();
      values.push(fst / snd);
    }
  }

  public boolean stackEmpty() {
    return values.isEmpty();
  }

  public int stackSize() {
    return values.size();
  }

  public Double peekStack() {
    if (stackEmpty()) {
      throw new UnsupportedOperationException("Stack is empty");
    }
    return values.peek();
  }
}
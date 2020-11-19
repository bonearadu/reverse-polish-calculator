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
    values.push(values.pop() + values.pop());
  }

  public void sub() {
    values.push(values.pop() - values.pop());
  }

  public void mul() {
    values.push(values.pop() * values.pop());
  }

  public void div() {
    Double snd = values.pop();
    Double fst = values.pop();
    values.push(fst / snd);
  }

  public Double peekStack() {
    return values.peek();
  }
}
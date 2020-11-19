package ic.doc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BackEndTest {
  BackEnd backEnd = new BackEnd();

  @Test
  public void initialStackIsEmpty() {
    assertTrue(backEnd.stackEmpty());
  }

  @Test
  public void canPushToStack() {
    backEnd.pushToStack(0);
    assertThat(backEnd.stackSize(), is(1));
    backEnd.pushToStack(-1);
    assertThat(backEnd.stackSize(), is(2));
  }

  @Test
  public void pushToStackPushesTheRightValue() {
    backEnd.pushToStack(0);
    assertThat(backEnd.peekStack(), is(0.0));
    backEnd.pushToStack(-123);
    assertThat(backEnd.peekStack(), is(-123.0));
  }

  @Test
  public void canAdd() {
    backEnd.pushToStack(1);
    backEnd.pushToStack(2);
    backEnd.add();
    assertThat(backEnd.peekStack(), is(3.0));
    assertThat(backEnd.stackSize(), is(1));
  }

  @Test
  public void addDoesNothingWhenStackNotBigEnough() {
    backEnd.add();
    assertTrue(backEnd.stackEmpty());
    backEnd.pushToStack(6);
    backEnd.add();
    assertThat(backEnd.peekStack(), is(6.0));
    assertThat(backEnd.stackSize(), is(1));
  }

  @Test
  public void canSub() {
    backEnd.pushToStack(1);
    backEnd.pushToStack(2);
    backEnd.sub();
    assertThat(backEnd.peekStack(), is(-1.0));
    assertThat(backEnd.stackSize(), is(1));
  }

  @Test
  public void subDoesNothingWhenStackNotBigEnough() {
    backEnd.sub();
    assertTrue(backEnd.stackEmpty());
    backEnd.pushToStack(6);
    backEnd.sub();
    assertThat(backEnd.peekStack(), is(6.0));
    assertThat(backEnd.stackSize(), is(1));
  }

  @Test
  public void canMul() {
    backEnd.pushToStack(3);
    backEnd.pushToStack(-11);
    backEnd.mul();
    assertThat(backEnd.peekStack(), is(-33.0));
    assertThat(backEnd.stackSize(), is(1));
  }

  @Test
  public void mulDoesNothingWhenStackNotBigEnough() {
    backEnd.mul();
    assertTrue(backEnd.stackEmpty());
    backEnd.pushToStack(6);
    backEnd.mul();
    assertThat(backEnd.peekStack(), is(6.0));
    assertThat(backEnd.stackSize(), is(1));
  }

  @Test
  public void canDiv() {
    backEnd.pushToStack(1);
    backEnd.pushToStack(2);
    backEnd.div();
    assertThat(backEnd.peekStack(), is(0.5));
    assertThat(backEnd.stackSize(), is(1));
  }

  @Test
  public void divDoesNothingWhenStackNotBigEnough() {
    backEnd.div();
    assertTrue(backEnd.stackEmpty());
    backEnd.pushToStack(11);
    backEnd.div();
    assertThat(backEnd.peekStack(), is(11.0));
    assertThat(backEnd.stackSize(), is(1));
  }
}

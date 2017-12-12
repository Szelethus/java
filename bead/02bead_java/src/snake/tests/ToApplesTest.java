package snake.tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import snake.Game;
import snake.exception.InvalidIndexException;
import java.util.*;

public class ToApplesTest
{

  @Test(expected = IllegalArgumentException.class)
  public void nullparam() throws IllegalArgumentException, InvalidIndexException
  {
    Game.toApples(null);
  }

  @Test
  public void emptyList() throws IllegalArgumentException, InvalidIndexException
  {
    assertTrue(Game.toApples(new ArrayList<String>()).size() == 0);
  }

  @Test
  public void startWithSpace()
      throws IllegalArgumentException, InvalidIndexException
  {
    ArrayList<String> list = new ArrayList<String>();
    list.add(" 9 9");
    assertTrue(Game.toApples(list).size() == 0);
  }

  @Test
  public void endWithSpace()
      throws IllegalArgumentException, InvalidIndexException
  {
    ArrayList<String> list = new ArrayList<String>();
    list.add("9 9 ");
    assertTrue(Game.toApples(list).size() == 1);
  }

  @Test
  public void moreSpaceDividor()
      throws IllegalArgumentException, InvalidIndexException
  {
    ArrayList<String> list = new ArrayList<String>();
    list.add("9  9");
    assertTrue(Game.toApples(list).size() == 0);
  }

  @Test
  public void invalidFormat()
      throws IllegalArgumentException, InvalidIndexException
  {
    ArrayList<String> list = new ArrayList<String>();
    list.add("a b");
    assertTrue(Game.toApples(list).size() == 0);
  }

  @Test
  public void negative() throws IllegalArgumentException, InvalidIndexException
  {
    ArrayList<String> list = new ArrayList<String>();
    list.add("-1 -1");
    assertTrue(Game.toApples(list).size() == 0);
  }

  @Test
  public void tooLarge() throws IllegalArgumentException, InvalidIndexException
  {
    ArrayList<String> list = new ArrayList<String>();
    list.add("10 10");
    assertTrue(Game.toApples(list).size() == 0);
  }

  @Test
  public void lowerBound()
      throws IllegalArgumentException, InvalidIndexException
  {
    ArrayList<String> list = new ArrayList<String>();
    list.add("0 0");
    assertTrue(Game.toApples(list).size() == 1);
  }

  @Test
  public void upperBound()
      throws IllegalArgumentException, InvalidIndexException
  {
    ArrayList<String> list = new ArrayList<String>();
    list.add("9 9");
    assertTrue(Game.toApples(list).size() == 1);
  }

  @Test
  public void multiLine() throws IllegalArgumentException, InvalidIndexException
  {
    ArrayList<String> list = new ArrayList<String>();
    list.add("9 9");
    list.add("8 9");
    list.add("7 9");
    assertTrue(Game.toApples(list).size() == 3);
  }
}

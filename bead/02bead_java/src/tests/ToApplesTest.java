package tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import snake.Game;
import snake.exception.InvalidIndexException;

public class ToApplesTest
{

  @Test(expected = IllegalArgumentException.class)
  public void nullparam() throws IllegalArgumentException, InvalidIndexException
  {
    Game game = new Game(null);
  }

  @Test
  public void nullparam() throws IllegalArgumentException, InvalidIndexException
  {
    Game game = new Game(new ArrayList<String>());
  }
}

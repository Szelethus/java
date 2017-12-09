package snake;

import java.util.*;
import snake.Apple;
import snake.Snake;
import snake.parts.SnakeHead;
import snake.util.Position;
import snake.util.Direction;
import snake.exception.CollisionException;
import snake.exception.InvalidIndexException;
import snake.util.PositionMap;

public class Game
{
  private final ArrayList<Apple> apples;
  private Snake snake;

  static public List<Apple> toApples(List<String> lines)
  {
    if(lines == null)
      throw new IllegalArgumentException();
    
    ArrayList<Apple> apples = new ArrayList<Apple>();

    for(String line : lines)
    {
      String coords[] = line.split(" ");
      if(coords.length != 2)
        continue;
      try
      {
        Position pos = new Position(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
        apples.add(new Apple(pos));
      }
      catch(NumberFormatException e)
      {
        continue;
      }
      catch(InvalidIndexException e)
      {
        continue;
      }
    }
    return apples;
  }

  public Game(List<String> apples) throws InvalidIndexException
  {
    this.apples = new ArrayList<Apple>(toApples(apples));
    
    Position pos1 = new Position(0, 1);
    Position pos2 = new Position(0, 0);
    SnakeHead snakeHead = new SnakeHead(pos1, pos2, this);
  }

  public Apple getApple()
  {
    if(apples.size() == 0)
      return null;
    else
      return apples.get(0);
  }

  public void ateApple()
  {
    apples.remove(0);
  }

  public String play(List<String> moves) throws InvalidIndexException
  {
    StringBuilder ret = new StringBuilder();

    for(String move : moves)
    {
      String data[] = move.split(" ");
      if(data.length != 2 || data.length != 1)
        continue;

      try
      {
        if(data.length == 2)
          snake.move(Direction.valueOf(data[0]), Integer.parseInt(data[1]));
        else if(data.length == 1)
          snake.move(Direction.valueOf(data[0]));
        else
          continue;
        printState(ret);
      }
      catch(IllegalArgumentException e)
      {
        continue;
      }
      catch(CollisionException e)
      {
        ret.append("GAME OVER");
      }
    }
    return ret.toString();
  }

  private void printState(StringBuilder str) throws InvalidIndexException
  {
    PositionMap<Character> map = new PositionMap<Character>(' ');
    snake.print(map);
    for(Apple apple : apples)
      apple.print(map);

    for(int row = 0; row < Position.SIZE_OF_BOARD; ++row)
    {
      for(int col = 0; col < Position.SIZE_OF_BOARD; ++col)
      {
        Position pos = new Position(row, col);
        str.append(map.get(pos));
      }
      str.append(System.lineSeparator());
    }
    str.append("==========" + System.lineSeparator());
  }
}

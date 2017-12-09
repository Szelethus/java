package snake;

import snake.Tile;
import snake.util.Position;

public class Apple implements Tile
{
  private final Position position;
  
  public Apple(Position position)
  {
    this.position = position;
  }

  public Position getPosition()
  {
    return position;
  }
}

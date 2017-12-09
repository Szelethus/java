import snake.Tile;
import snake.util.Position;

public class SnakeTail implements Tile
{
  private Position position;

  public SnakeTail(Position position)
  {
    this.position = position;
  }

  @Override
  public Position getPosition()
  {
    return Position;
  }

  protected void moveTo(Position pos)
  {
    this.position = pos;
  }

  protected boolean isAt(Position pos)
  {
    return position.equals(pos);
  }
}

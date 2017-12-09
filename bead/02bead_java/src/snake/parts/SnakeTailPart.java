package snake.parts;

import snake.parts.SnakeTail;
import snake.util.Position;
import snake.util.PositionMap;

public class SnakeTailPart extends SnakeTail
{
  private final SnakeTail next;

  public SnakeTailPart(Position position, SnakeTail next)
  {
    super(position);
    if (next == null)
      throw new IllegalArgumentException();
    this.next = next;
  }

  @Override
  protected void moveTo(Position pos)
  {
    next.moveTo(this.position);
    super.moveTo(pos);
  }

  @Override
  protected boolean isAt(Position pos)
  {
    if (position.equals(pos))
      return true;
    return next.isAt(pos);
  }

  @Override
  public void print(PositionMap<Character> map)
  {
    map.put(position, '#');
    next.print(map);
  }
}

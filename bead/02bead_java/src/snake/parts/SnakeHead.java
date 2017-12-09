package snake.parts;

import snake.util.Position;
import snake.Snake;
import snake.parts.SnakeTail;
import snake.Game;
import snake.util.Direction;
import snake.exception.CollisionException;
import snake.exception.InvalidIndexException;

public class SnakeHead extends SnakeTail implements Snake
{
  private final Game game;
  private SnakeTail tail;

  public SnakeHead(Position position, Position positionOfTail, Game game)
  {
    super(position);
    this.game = game;
    tail = new SnakeTail(positionOfTail);
  }

  @Override
  public void move(Direction dir, int times) throws CollisionException
  {
    for(int i = 0; i < times; ++i)
      move(dir);
  }

  @Override
  public void move(Direction direction) throws CollisionException
  {
    switch(direction)
    {
      case UP:
        move(position.getRow() - 1, position.getColumn()); 
        break;
      case DOWN:
        move(position.getRow() + 1, position.getColumn()); 
        break;
      case RIGHT:
        move(position.getRow(), position.getColumn() + 1); 
        break;
      case LEFT:
        move(position.getRow(), position.getColumn() - 1); 
        break;
    }
  }

  private void move(int x, int y) throws CollisionException
  {
    try
    {
      Position pos = new Position(x, y);
      if(isAt(pos))
        throw new CollisionException();
     //TODO 
    }
    catch(InvalidIndexException e)
    {
      throw new CollisionException();
    }
  }
}

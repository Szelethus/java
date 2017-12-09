import snake.Snake;
import snake.SnakeTail;

public class SnakeHead implements Snake
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
  public void move(Direction dir, int times)
  {
    for(int i = 0; i < times; ++i)
      move(dir);
  }

  @Override
  public 
}

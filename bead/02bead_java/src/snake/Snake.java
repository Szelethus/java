public interface Snake extends Tile
{
  public void move(Direction direction) throws CollisionException;
  public void move(Direction direction, int times) throws CollisionException;
}

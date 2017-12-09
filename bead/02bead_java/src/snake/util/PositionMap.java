package snake.util;

import java.util.*;

public class PositionMap<T>
{
  private final Map<Position, T> map;
  private final T defaultValue;

  public PositionMap(T defaultValue)
  {
    map = new HashMap<Position, T>();
    this.defaultValue = defaultValue;
  }

  public void put(Position pos, T element)
  {
    map.put(pos, element);
  }

  public T get(Position pos)
  {
    T ret = map.get(pos);
    return ret == null ? defaultValue : ret;
  }
}

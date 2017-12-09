package snake.util;

import snake.exception.InvalidIndexException;

public class Position
{
  public static final int SIZE_OF_BOARD = 10;
  private final int row;
  private final int column;

  public Position(int row, int col) throws InvalidIndexException
  {
    if(row >= 0 && row < SIZE_OF_BOARD &&
       col >= 0 && col < SIZE_OF_BOARD)
    {
      this.row = row;
      this.column = col;
    }
    else
    {
      throw new InvalidIndexException();
    }
  }

  public int getRow()
  {
    return row;
  }

  public int getColumn()
  {
    return column;
  }

  public boolean isSame(Position other)
  {
    return other != null && row == other.row && column == other.column;
  }

  @Override
  public boolean equals(Object obj)
  {
    if(obj != null && obj instanceof Position)
    {
      Position other = (Position) obj;
      return this.row == other.row && this.column == other.column;
    }
    else
      return false;
  }

  @Override
  public int hashCode()
  {
    return row * 5 + column * 10;
  }
}

public class Point implements Comparable<Point>
{
  private int x, y;

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public void setX(int x)
  {
    this.x = x;
  }

  public void setY(int y)
  {
    this.y = y;
  }

  @Override public String toString()
  {
    return "(" + x + ", " + y + ")";
  }

  @Override public int hashCode()
  {
    return x + y + x * y;
  }

  @Override public boolean equals(Object obj)
  {
    if (obj != null && obj instanceof Point)
    {
      Point other = (Point)obj;
      return (other.x == this.x && other.y == this.y);
    }
    return false;
  }

  @Override public int compareTo(Point other)
  {
    if (this.x < other.x)
      return -1;
    else if (this.x == other.y)
      return 0;
    else
      return 1;
  }
}

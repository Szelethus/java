package polyhedra;

public abstract class Prism
{
  private double height;

  public abstract double baseArea();

  public double volume()
  {
    return height * baseArea();
  }
}

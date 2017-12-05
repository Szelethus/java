package polyhedra;

import polyhedra.Prism;

public class Cylinder extends Prism
{
  private double radius;

  @Override public double baseArea()
  {
    return Math.PI * radius * radius;
  }
}

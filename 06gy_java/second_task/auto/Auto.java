package auto;

import auto.color.Color;

public class Auto
{
  private String licensePlate;
  private Color color;
  private int maxSpeed;

  private static int counter = 0;
  
  public Auto(String licensePlate, Color color, int maxSpeed)
  {
    this.licensePlate = licensePlate;
    this.color = color;
    this.maxSpeed = maxSpeed;
    counter++;
  }

  public Auto()
  {
    this("AAA-000", Color.BLUE, 120);
  }

  public static boolean compare(Auto lhs, Auto rhs)
  {
    return lhs.maxSpeed > rhs.maxSpeed;
  }
}

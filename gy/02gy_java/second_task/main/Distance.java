package main;
import descartes.Point;

public class Distance
{
  public static void main(String[] args)
  {
    double distance = 0;

    Point p1 = new Point();

    if (args.length >= 2)
    {
      p1.x = Integer.parseInt(args[0]);
      p1.y = Integer.parseInt(args[1]);
    }

    for (int i = 0; i < args.length; i = i + 2)
    {

      Point p2 = new Point();
      p2.x = Integer.parseInt(args[i]);
      p2.y = Integer.parseInt(args[i + 1]);

      distance += Point.getDistance(p1, p2);

      p1 = p2;
    }

    System.out.println(distance);
  }
}
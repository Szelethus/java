package main;

import utils.basics.Point;
import geo.Circle;

public class PointCircleTest
{

  public static void main(String[] args)
  {

    Point p = new Point(1.22, 1.33);

    System.out.println(p.getX());
    System.out.println(p.getY());
    p.setX(1.23);
    p.setY(2.56);
    System.out.println(p.getX());
    System.out.println(p.getY());
    p.move(1.22, 1.33);
    System.out.println(p.getX());
    System.out.println(p.getY());

    Circle c = new Circle();

    c.setCenter(p);
    c.setRadius(3.21);
    System.out.println(c.getRadius());
    c.move(1.22, 1.33);
    System.out.println(c.getCenter().getX());
    System.out.println(c.getCenter().getY());

    c.enlarge(2);

    System.out.println(c.getCenter().getX());
    System.out.println(c.getCenter().getY());
    System.out.println(c.getRadius());

    Point q = new Point(1.1, 2.2);

    System.out.println(q.getX());
    System.out.println(q.getY());

    Circle a = new Circle(q, 3.4);

    System.out.println(a.getCenter().getX());
    System.out.println(a.getCenter().getY());
    System.out.println(a.getRadius());

    Circle b = new Circle(1.3, 4.5);

    System.out.println(b.getCenter().getX());
    System.out.println(b.getCenter().getY());
    System.out.println(b.getRadius());

    Circle d = new Circle();

    System.out.println(d.getCenter().getX());
    System.out.println(d.getCenter().getY());
    System.out.println(d.getRadius());
  }
}

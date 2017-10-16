package geo;

import utils.basics.Point;

public class Circle {

    private Point center;
    private double radius;
	
	public Circle(Point p, double radius) {
		center = new Point(0.0,0.0);
        center.setX(p.getX());
		center.setY(p.getY());
        this.radius = radius;  
    }

    public Circle(double x, double y) {
		center = new Point(0.0,0.0);
        center.setX(x);
		center.setY(y);
    }

    public Circle() {
		center = new Point(0.0,0.0);
        center.setX(0.0);
		center.setY(0.0);
	}
	
	public Point getCenter() {
        Point result = new Point(0.0,0.0);
		result.setX(center.getX());
        result.setX(center.getY());
        return result;
    }

    public void setCenter(Point center) {
		Point result = new Point(0.0,0.0);
        this.center.setX(center.getX());
		this.center.setY(center.getY());
    }

	public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        if (r < 0.0) r = 0.0;
        radius = r;
    }

	  public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    public void enlarge(double factor) {
        radius *= factor;
    }

    public String toString(){
      return "Center: " + center.toString() + " Radius: " + radius;
    }

    public void newCenter(Point center){
      setCenter(center);
    }
    
    public double area(){
      return Math.PI * Math.PI * radius;
    }
    
    public boolean isPointOnCircle(Point other){
      return center.distance(other) - radius < 0.001;
    } 
    
    public boolean isPointInCircle(Point other){
      return center.distance(other) <= radius;
    }

}





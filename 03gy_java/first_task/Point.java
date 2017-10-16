class Point{
	
    private double x;
    private double y;
	
	public Point(double x, double y) {
        this.x=x;
        this.y=y;
    }
	
	public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
	
	public void setY(double y) {
        this.y = y;
    }
	
    public void move(double dx, double dy) {
		x += dx;
		y += dy;
    }
    
    public double distance(Point other){
      return Math.sqrt( (x - other.x) * (x - other.x) + (y - other.y) * (y - other.y) );
    }
    
    public static double distance(Point lhs, Point rhs){
      return Math.sqrt( (lhs.x - rhs.x) * (lhs.x - rhs.x) + (lhs.y - rhs.y) * (lhs.y - rhs.y) );
    }
    public String toString(){
      return "X: " + x + " Y: " + y;
    }
} 

public class Vector {

    // Declare my instance variables!
    private double x;
    private double y;

    
    public Vector(double x, double y) {
        // Impelement me!
        this.x = x;
        this.y = y;
    }
    
    public double x() {
        // Implement me!
        return x;
    }
    
    public double y() {
        // Implement me!
        return y;
    }

    public Vector add(Vector v) {
        // Implement me!
       
        return new Vector(this.x + v.x, this.y + v.y);
    }

    public Vector scale(double magnitude) {
        // Implement me!
        return new Vector(this.x * magnitude, this.y * magnitude);
    }

    public boolean equals(Vector v){
        return this.x == v.x && this.y == v.y;
    }
}

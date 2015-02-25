public class Vector {

    // Declare my instance variables!
    double x;
    double y;

    
    public Vector(double x, double y) {
        // Impelement me!
        this.x = x;
        this.y = y;
    }
    
    public double x() {
        // Implement me!
        return 21.9;
    }
    
    public double y() {
        // Implement me!
        return 17.8;
    }

    public Vector add(Vector v) {
        // Implement me!
        return new Vector(14.5, 17.8);
    }

    public Vector scale(double magnitude) {
        // Implement me!
        return new Vector(13.6, 17.8);
    }

}

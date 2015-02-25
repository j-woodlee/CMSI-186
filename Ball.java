public class Ball {

    // Declare my instance variables!
    double radius;
    Vector location;
    Vector initialVelocity;

    
    public Ball(double radius, Vector location, Vector initialVelocity) {
        // Implement me!
        this.radius = radius;
        this.location = location;
        this.initialVelocity = initialVelocity;

    }

    public Vector getLocation() {
        // Implement me!
        return location;
    }

    public double getRadius() {
        // Implement me!
        return radius;
    }
    
    public void accelerate(Vector acceleration, double grain) {
        // Implement me!
        
    }

    public void move(double grain) {
        // Implement me!
    }

}

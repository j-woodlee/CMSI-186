public class Ball {

    // Declare my instance variables!
    private double radius;
    private Vector location;
    private Vector velocity;

    
    public Ball(double radius, Vector location, Vector initialVelocity) {
        // Implement me!
        this.radius = radius;
        this.location = location;
        velocity = initialVelocity;
    }

    public Vector getLocation() {
        // Implement me!
        return location;
    }

    public double getRadius() {
        // Implement me!
        return radius;
    }

    public Vector getVelocity(){
        return velocity;
    }
    
    public void accelerate(Vector acceleration, double grain) {
        //<0,-9.8>
        this.velocity = this.velocity.add(acceleration.scale(grain));
    }

    public void move(double grain) {
        // Implement me!
        this.location = this.location.add(this.velocity.scale(grain));
    }

}

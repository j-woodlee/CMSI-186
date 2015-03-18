public class Ball {

    // Declare my instance variables!
    private double radius;
    private Vector location;
    private Vector velocity;
    private boolean stopped;

    
    public Ball(double radius, Vector location, Vector initialVelocity) {
        // Implement me!
        this.radius = radius;
        this.location = location;
        this.velocity = initialVelocity;
        this.stopped = false;
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

    public void stop(){
        this.stopped = true;
    }

    public double getDistance(Ball b){//returns distance between this and b from the center
        return Math.sqrt(Math.pow(this.location.x() - b.getLocation().x(),2) + Math.pow(this.location.y() - b.getLocation().y(),2));
    }
    
    public void accelerate(Vector acceleration, double grain) {
        //acceleration is <0,-9.8> for this simulation, and will not vary, however it should not matter
        this.velocity = this.velocity.add(acceleration.scale(grain));
    }

    public void move(double grain) {
        // Implement me!
        this.location = this.stopped ? this.location : this.location.add(this.velocity.scale(grain));
    }

    public boolean isTouching(Ball b){//return true if this is within or touching the radius of b
        return this.getDistance(b) - (b.getRadius() + this.getRadius()) <= 0;
    }

}

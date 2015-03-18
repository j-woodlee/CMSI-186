public class AngryBallsSimulation{

    private Ball redBall;
    private Ball blueBall;
    private double grain;
    private Vector acceleration;
    private double time;
    private boolean collided;

    public AngryBallsSimulation(Ball redBall, Ball blueBall, Vector acceleration, double grain){
        this.redBall = redBall;
        this.blueBall = blueBall;
        this.grain = grain;
        this.acceleration = acceleration;
        this.time = 0;
        collided = false;
    }

    public static void main(String[] args) {
        // Ball(double radius, Vector location, Vector initialVelocity)
        // Vector(double x, double y)
        if(args.length == 0) {
            displayUsage();
            return;
        }

        AngryBallsSimulation sim;

        double[] values = new double[args.length];
        try {
            for(int i = 0; i < args.length;i++) {
                values[i] = Double.parseDouble(args[i]);
            }
        } catch(NumberFormatException nfe) {
            System.out.println("The arguments supplied do not match what AngryBallsSimulation expects. ");
            displayUsage();
        }

         Vector gravity = new Vector(0,-9.8);

         Ball redBall = new Ball(values[0], new Vector(values[1], values[2]), new Vector(values[3], values[4]));
         Ball blueBall = new Ball(values[5], new Vector(values[6], values[7]), new Vector(values[8], values[9]));

         sim = args.length == 11 ? new AngryBallsSimulation(redBall, blueBall, gravity, values[10]): new AngryBallsSimulation(redBall, blueBall, gravity, 1.0);

         sim.startSim();
         
    }

    public static void displayUsage() {
        System.out.println("Usage: java AngryBallsSimulation <redradius> <red x> <red y> <red velocity x><red velocity y> <blue radius> <blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ]");
        System.out.println("All sizes are in meters and the grain is in seconds. The grain is optional and defaults to 1 second if not supplied.");
    }

    public boolean getCollided(){
        return this.collided;
    }

    public Ball getRedBall(){
        return redBall;
    }

    public Ball getBlueBall(){
        return blueBall;
    }

    public double getTime(){
        return time;
    }

    public Vector getAcceleration(){
        return acceleration;
    }

    public double getGrain(){
        return grain;
    }

    public void startSim(){

         Vector redBallCollisionLocation = null;
         Vector blueBallCollisionLocation = null;

         while (redBall.getLocation().y() > 0 || blueBall.getLocation().y() > 0) {

            redBall.move(this.grain);
            redBall.accelerate(this.acceleration, this.grain);
            blueBall.move(this.grain);
            blueBall.accelerate(this.acceleration, this.grain);
            this.time += this.grain;

            if(redBall.isTouching(blueBall) && !this.collided) {//Will not be satisfied once collided == true
                this.collided = true;
                redBallCollisionLocation = new Vector(redBall.getLocation().x(),redBall.getLocation().y());
                blueBallCollisionLocation = new Vector (blueBall.getLocation().x(), blueBall.getLocation().y());
            }

            System.out.println(redBall.getRadius() + " " + redBall.getLocation() + " " + blueBall.getRadius() + " " + blueBall.getLocation());

            if(redBall.getLocation().y() <= 0) {
                redBall.stop();
            }
            if(blueBall.getLocation().y() <= 0) {
                blueBall.stop();
            }
         }

         System.out.println("end");

         if (this.collided) {
            System.out.println("The balls collided at timestamp " + this.time  + " with the "); 
            System.out.println("red ball at ("+ redBallCollisionLocation.x() + ", " + redBallCollisionLocation.y()+ ") " +  "and the blue ball at");
            System.out.println("(" + blueBallCollisionLocation.x() + ", " + blueBallCollisionLocation.y() + ").");
         } else {
            System.out.println("The balls did not collide.");
         }

         
    }

}

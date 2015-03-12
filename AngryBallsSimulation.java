public class AngryBallsSimulation{

    public static void main(String[] args) {
        // Ball(double radius, Vector location, Vector initialVelocity)
        // Vector(double x, double y)
        if(args.length == 0) {
            displayUsage();
            return;
        }

        
        double[] values = new double[args.length];
        try {
            for(int i = 0; i<args.length;i++) {
                values[i] = Double.parseDouble(args[i]);
            }
        } catch(NumberFormatException nfe) {
            System.out.println("The arguments supplied do not match what AngryBallsSimulation expects. ");
            displayUsage();
        }

         Ball redBall = new Ball(values[0], new Vector(values[1], values[2]), new Vector(values[3], values[4]));
         Ball blueBall = new Ball(values[5], new Vector(values[6], values[7]), new Vector(values[8], values[9]));

         double grain = args.length == 11 ? values[10] : 1;

         //y-component of the position is <= 0 when the ball hits the ground
         Vector gravity = new Vector(0,-9.8);
         boolean collided = false;
         Vector redBallCollisionLocation = null;
         Vector blueBallCollisionLocation = null;
         double t = 0;

         while (redBall.getLocation().y() > 0 || blueBall.getLocation().y() > 0) {

            redBall.move(grain);
            redBall.accelerate(gravity, grain);
            blueBall.move(grain);
            blueBall.accelerate(gravity, grain);
            t += grain;

            if(redBall.isTouching(blueBall) && !collided) {//Will not be satisfied once collided == true
                collided = true;
                redBallCollisionLocation = new Vector(redBall.getLocation().x(),redBall.getLocation().y());
                blueBallCollisionLocation = new Vector (blueBall.getLocation().x(), blueBall.getLocation().y());
            }

            System.out.println(redBall.getRadius() + " " + redBall.getLocation() + " " + blueBall.getRadius() + " " + blueBall.getLocation());
         }

         System.out.println("end");
         if (collided) {
            System.out.println("The balls collided at timestamp " + t  + " with the "); 
            System.out.println("red ball at ("+ redBallCollisionLocation.x() + ", " + redBallCollisionLocation.y()+ ") " +  "and the blue ball at");
            System.out.println("(" + blueBallCollisionLocation.x() + ", " + blueBallCollisionLocation.y() + ").");
         } else {
            System.out.println("The balls did not collide.");
         }
    }

    public static void displayUsage() {
        System.out.println("Usage: java AngryBallsSimulation <redradius> <red x> <red y> <red velocity x><red velocity y> <blue radius> <blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ]");
        System.out.println("All sizes are in meters and the grain is in seconds. The grain is optional and defaults to 1 second if not supplied.");
    }
}

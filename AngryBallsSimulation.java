public class AngryBallsSimulation{

    public static void main(String[] args){
        // Ball(double radius, Vector location, Vector initialVelocity)
        // Vector(double x, double y)
        if(args.length == 0){
            System.out.println("Usage: java AngryBallsSimulation <red radius> <red x> <red y> <red velocity x> <red velocity y> <blue radius> <blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ] ");
            System.out.println("All sizes are in meters and the grain is in seconds. The grain is optional and defaults to 1 second if not supplied.");
            return;
        }

        double grain = 1;
        double[] values = new double[args.length];
        try{
            for(int i = 0; i<args.length;i++){
                values[i] = Double.parseDouble(args[i]);
            }
        } catch(NumberFormatException nfe) {
            System.out.println("The arguments supplied do not match what AngryBallsSimulation expects. ");
            System.out.println("Usage: java AngryBallsSimulation <redradius> <red x> <red y> <red velocity x><red velocity y> <blue radius> <blue x> <blue y> <blue velocity x> <blue velocity y> [ <grain> ]");
            System.out.println("All sizes are in meters and the grain is in seconds. The grain is optional and defaults to 1 second if not supplied.");
        }

         Ball redBall = new Ball(values[0], new Vector(values[1], values[2]), new Vector(values[3], values[4]));
         Ball blueBall = new Ball(values[5], new Vector(values[6], values[7]), new Vector(values[8], values[9]));
         if(args.length == 11){
             grain = values[10];
         }
         //y-component of the position is <= 0 the ball hits the ground
         Vector gravity = new Vector(0,-9.8);

         while(redBall.getLocation().y() > 0 && blueBall.getLocation().y() > 0){

            redBall.move(grain);
            redBall.accelerate(gravity, grain);
            blueBall.move(grain);
            blueBall.accelerate(gravity, grain);

            System.out.println("Red Ball: " + redBall.getRadius() + " " + redBall.getLocation() +  " Blue Ball: " + blueBall.getRadius() + " " + blueBall.getLocation());
         }
         
    }
}

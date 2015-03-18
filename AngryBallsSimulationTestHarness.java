public class AngryBallsSimulationTestHarness {
     static int successes = 0;
     static int attempts = 0;

    public static void main(String[] args){
        attempts = 0;
        successes = 0;

        testConstructor();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {//courtesy of Dondi
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void testConstructor(){

        System.out.println("Testing the simulation constructor...");

        Ball ball1 = new Ball(10, new Vector(0,0), new Vector(10,10));
        Ball ball2 = new Ball(10, new Vector(0,0), new Vector(10,10));
        Vector acceleration = new Vector(0, -9.8);
        double grain = 1.0;

        AngryBallsSimulation sim = new AngryBallsSimulation(ball1, ball2, acceleration, grain);

        try {
            displaySuccessIfTrue(sim.getRedBall().getRadius() == ball1.getRadius() &&
            sim.getBlueBall().getRadius() == ball2.getRadius() &&
            sim.getRedBall().getVelocity().equals(ball1.getVelocity()) &&
            sim.getBlueBall().getVelocity().equals(ball2.getVelocity()) &&
            sim.getGrain() == grain &&
            sim.getAcceleration().equals(acceleration));
        } catch(Exception exc) {
            displayFailure();
        }

        ball1 = new Ball(4.5, new Vector(543,532), new Vector(80,80));
        ball2 = new Ball(6.5, new Vector(1274,123), new Vector(67.5,75.5));
        grain = 1.2;
        acceleration = new Vector(9.8,-9.8);

        sim = new AngryBallsSimulation(ball1, ball2, acceleration, grain);


        try {
            displaySuccessIfTrue(sim.getRedBall().getRadius() == ball1.getRadius() &&
            sim.getBlueBall().getRadius() == ball2.getRadius() &&
            sim.getRedBall().getVelocity().equals(ball1.getVelocity()) &&
            sim.getBlueBall().getVelocity().equals(ball2.getVelocity()) &&
            sim.getGrain() == grain &&
            sim.getAcceleration().equals(acceleration));
        } catch(Exception exc) {
            displayFailure();
        }

        ball1 = new Ball(-4.5, new Vector(23,53.4), new Vector(80,80));
        ball2 = new Ball(6.5, new Vector(123.4,134.5), new Vector(-123,1233123));
        grain = .1;
        acceleration = new Vector(9.8,-9.8);

        sim = new AngryBallsSimulation(ball1, ball2, acceleration, grain);

        try {
            displaySuccessIfTrue(sim.getRedBall().getRadius() == ball1.getRadius() &&
            sim.getBlueBall().getRadius() == ball2.getRadius() &&
            sim.getRedBall().getVelocity().equals(ball1.getVelocity()) &&
            sim.getBlueBall().getVelocity().equals(ball2.getVelocity()) &&
            sim.getGrain() == grain &&
            sim.getAcceleration().equals(acceleration)
            );
        } catch(Exception exc) {
            displayFailure();
        }

        ball1 = new Ball(0.1, new Vector(53,53), new Vector(20,-80));
        ball2 = new Ball(.08, new Vector(1323,123), new Vector(-1,10000));
        grain = 1.2;
        acceleration = new Vector(9.8,-9.8);

        sim = new AngryBallsSimulation(ball1, ball2, acceleration, grain);

        try {
            displaySuccessIfTrue(sim.getRedBall().getRadius() == ball1.getRadius() &&
            sim.getBlueBall().getRadius() == ball2.getRadius() &&
            sim.getRedBall().getVelocity().equals(ball1.getVelocity()) &&
            sim.getBlueBall().getVelocity().equals(ball2.getVelocity()) &&
            sim.getGrain() == grain &&
            sim.getAcceleration().equals(acceleration)
            );
        } catch(Exception exc) {
            displayFailure();
        }

        ball1 = new Ball(-123, new Vector(53,23), new Vector(-20,-80));
        ball2 = new Ball(.08, new Vector(1453,34), new Vector(-1,9120));
        grain = 0.5;
        acceleration = new Vector(100.01,-10.01);

        sim = new AngryBallsSimulation(ball1, ball2, acceleration, grain);

        try {
            displaySuccessIfTrue(sim.getRedBall().getRadius() == ball1.getRadius() &&
            sim.getBlueBall().getRadius() == ball2.getRadius() &&
            sim.getRedBall().getVelocity().equals(ball1.getVelocity()) &&
            sim.getBlueBall().getVelocity().equals(ball2.getVelocity()) &&
            sim.getGrain() == grain &&
            sim.getAcceleration().equals(acceleration)
            );
        } catch(Exception exc) {
            displayFailure();
        }
    }
}

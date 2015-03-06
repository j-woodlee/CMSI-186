public class BallTestHarness {
    private static int successes = 0;
    private static int attempts = 0;

    public static void main(String[] args){
        attempts = 0;
        successes = 0;

        testConstructor();
        testAccelerate();
        testMove();

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
        System.out.println("Testing Balls's Constructor...");
        double radius = 10.5;
        Vector location = new Vector(0,0);
        Vector velocity = new Vector(50,69);

        Ball b = new Ball(radius,location,velocity);

        try {
            displaySuccessIfTrue(b.getRadius() == radius && b.getLocation().equals(location) && b.getVelocity().equals(velocity));
        } catch(Exception exc) {
            displayFailure();
        }

        radius = 45.76767;
        location = new Vector(13,17);
        velocity = new Vector(18,90);
        b = new Ball(radius,location,velocity);

        try {
            displaySuccessIfTrue(b.getRadius() == radius && b.getLocation().equals(location) && b.getVelocity().equals(velocity));
        } catch(Exception exc) {
            displayFailure();
        }

        radius = 0;
        location = new Vector(0,0);
        velocity = new Vector(0,0);
        b = new Ball(radius,location,velocity);

        try {
            displaySuccessIfTrue(b.getRadius() == radius && b.getLocation().equals(location) && b.getVelocity().equals(velocity));
        } catch(Exception exc) {
            displayFailure();
        }

        radius = 0.22;
        location = new Vector(0.75,17);
        velocity = new Vector(90,0.67);
        b = new Ball(radius,location,velocity);

        try {
            displaySuccessIfTrue(b.getRadius() == radius && b.getLocation().equals(location) && b.getVelocity().equals(velocity));
        } catch(Exception exc) {
            displayFailure();
        }

        radius = 78;
        location = new Vector(13.89,17);
        velocity = new Vector(18,90.09);
        b = new Ball(radius,location,velocity);

        try {
            displaySuccessIfTrue(b.getRadius() == radius && b.getLocation().equals(location) && b.getVelocity().equals(velocity));
        } catch(Exception exc) {
            displayFailure();
        }

    }

    public static void testAccelerate(){
        System.out.println("Testing Accelerate...");


        Ball b = new Ball(10, new Vector(0,0), new Vector(10,10));
        b.accelerate(new Vector(0,-9.8), 0.5);
        System.out.println(b.getVelocity());

        try {
            displaySuccessIfTrue(b.getVelocity().equals(new Vector(10,5.1)));
        } catch(Exception exc) {
            displayFailure();
        }

        b = new Ball(10, new Vector(0,0), new Vector(10,10));
        b.accelerate(new Vector(0,-9.5),1);
        System.out.println(b.getVelocity());

        try {
            displaySuccessIfTrue(b.getVelocity().equals(new Vector(10,0.5)));
        } catch(Exception exc) {
            displayFailure();
        }

        b = new Ball(10, new Vector(0,0), new Vector(10,10));
        b.accelerate(new Vector(0,-9.5),1);
        System.out.println(b.getVelocity());

        try {
            displaySuccessIfTrue(b.getVelocity().equals(new Vector(10,0.5)));
        } catch(Exception exc) {
            displayFailure();
        }

        b = new Ball(10, new Vector(0,0), new Vector(32,23));
        b.accelerate(new Vector(0,-9.5),0);
        System.out.println(b.getVelocity());

        try {
            displaySuccessIfTrue(b.getVelocity().equals(new Vector(32,23)));
        } catch(Exception exc) {
            displayFailure();
        }

        b = new Ball(10, new Vector(0,0), new Vector(32,-23));
        b.accelerate(new Vector(0,-5),3);
        System.out.println(b.getVelocity());

        try {
            displaySuccessIfTrue(b.getVelocity().equals(new Vector(32,-23-15)));
        } catch(Exception exc) {
            displayFailure();
        }

        b = new Ball(10, new Vector(0,0), new Vector(32,23));
        b.accelerate(new Vector(-5,-5),0.3);
        System.out.println(b.getVelocity());

        try {
            displaySuccessIfTrue(b.getVelocity().equals(new Vector(32 + (-5*.3),23 + (-5*.3))));
        } catch(Exception exc) {
            displayFailure();
        }


    }

    public static void testMove(){
        System.out.println("Testing Move...");

        Ball b = new Ball(10, new Vector(0,0), new Vector(10,10));

        b.move(4.5);
        System.out.println(b.getLocation());

        try {
            displaySuccessIfTrue(b.getLocation().equals(new Vector(45,45)));
        } catch(Exception exc) {
            displayFailure();
        }

        b = new Ball(10, new Vector(0,0), new Vector(10,10));

        b.move(1);
        System.out.println(b.getLocation());

        try {
            displaySuccessIfTrue(b.getLocation().equals(new Vector(10,10)));
        } catch(Exception exc) {
            displayFailure();
        }

        b = new Ball(10, new Vector(-34,-56), new Vector(4.5,7.6));
        b.move(1);
        System.out.println(b.getLocation());

        try {
            displaySuccessIfTrue(b.getLocation().equals(new Vector(-34 + 4.5, -56 + 7.6)));
        } catch(Exception exc) {
            displayFailure();
        }

        b = new Ball(10, new Vector(-34,-56), new Vector(4.5,7.6));
        b.move(2.5);
        System.out.println(b.getLocation());

        try {
            displaySuccessIfTrue(b.getLocation().equals(new Vector(-34 + 2.5*4.5,-56 + 2.5*7.6)));
        } catch(Exception exc) {
            displayFailure();
        }

    }
}

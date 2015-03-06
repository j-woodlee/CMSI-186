public class VectorTestHarness {
    static int successes = 0;
    static int attempts = 0;

    public static void main(String[] args){
        attempts = 0;
        successes = 0;

        testConstructor();
        testAdd();
        testScale();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {//method is courtesy of Dondi
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void testConstructor(){
        System.out.println("Testing Vector's Constructor...");

        Vector v = new Vector(1,2);
        try {
            displaySuccessIfTrue(v.x() == 1 && v.y() == 2);
        } catch(Exception exc) {
            displayFailure();
        }

        v = new Vector(2, 3);
        try {
            displaySuccessIfTrue(v.x() == 2 && v.y() == 3);
        } catch(Exception exc) {
            displayFailure();
        }

        v = new Vector(4,5);
        try {
            displaySuccessIfTrue(v.x() == 4 && v.y() == 5);
        } catch(Exception exc) {
            displayFailure();
        }

        v = new Vector(6,7);
        try {
            displaySuccessIfTrue(v.x() == 6 && v.y() == 7);
        } catch(Exception exc) {
            displayFailure();
        }

        v = new Vector(10,11);
        try {
            displaySuccessIfTrue(v.x() == 10 && v.y() == 11);
        } catch(Exception exc) {
            displayFailure();
        }
    }

    public static void testAdd() {//need to add 0 case and negative case

        System.out.println("Testing Vector's add method...");

        Vector v = new Vector(1,2);

        try {
            displaySuccessIfTrue(v.add(new Vector(2,1)).equals(new Vector(3,3)));
        } catch(Exception exc) {
            displayFailure();
        }


        try {
            displaySuccessIfTrue(v.add(new Vector(0,0)).equals(new Vector(1,2)));
        } catch(Exception exc) {
            displayFailure();
        }

        v = new Vector(0,1);

        try {
            displaySuccessIfTrue(v.add(new Vector(-5,-5)).equals(new Vector(-5,-4)));
        } catch(Exception exc) {
            displayFailure();
        }

        v = new Vector(0,0);
        try {
            displaySuccessIfTrue(v.add(new Vector(0,0)).equals(new Vector(0,0)));
        } catch(Exception exc) {
            displayFailure();
        }

        v = new Vector(1,2);

        try {
            displaySuccessIfTrue(v.add(new Vector(-5,-9)).equals(new Vector(-4,-7)));
        } catch(Exception exc) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(v.add(new Vector(1,1)).equals(new Vector(2,3)));
        } catch(Exception exc) {
            displayFailure();
        }

        v = new Vector(5,5);
        try{
             displaySuccessIfTrue(v.add(new Vector(4,0)).equals(new Vector(9,5)));
        }
        catch(Exception exc){
            displayFailure();
        }
        
        v = new Vector(3,1);

        try{
             displaySuccessIfTrue(v.add(new Vector(4,1)).equals(new Vector(7,2)));
        }
        catch(Exception exc){
            displayFailure();
        }

        v = new Vector(3,-99);

        try{
             displaySuccessIfTrue(v.add(new Vector(4,1)).equals(new Vector(7,-98)));
        }
        catch(Exception exc){
            displayFailure();
        }
    }

    public static void testScale() {//need to add 0 case and negative case
        System.out.println("Testing Vector's scale method...");

        Vector v = new Vector(6,7);
        try{
             displaySuccessIfTrue(v.scale(3).equals(new Vector(18,21)));
        }
        catch(Exception exc){
            displayFailure();
        }

        v = new Vector(24,56);
        try{
             displaySuccessIfTrue(v.scale(2).equals(new Vector(24*2,56*2)));
        }
        catch(Exception exc){
            displayFailure();
        }

        v = new Vector(0,0);

        try{
             displaySuccessIfTrue(v.scale(2).equals(new Vector(0,0)));
        }
        catch(Exception exc){
            displayFailure();
        }

        v = new Vector(1,1);

        try{
             displaySuccessIfTrue(v.scale(2).equals(new Vector(2,2)));
        }
        catch(Exception exc){
            displayFailure();
        }

        v = new Vector(-9,-2);

        try{
             displaySuccessIfTrue(v.scale(-7).equals(new Vector(63,14)));
        }
        catch(Exception exc){
            displayFailure();
        }

        try{
             displaySuccessIfTrue(v.scale(5).equals(new Vector(-9*5,-2*5)));
        }
        catch(Exception exc){
            displayFailure();
        }
    }
}

public class VectorTestHarness {
	static int successes = 0;
	static int attempts = 0;

	public static void main(String[] args){
		testConstructor();
		testAdd();
		testScale();
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

	public static void testAdd() {

		System.out.println("Testing Vector's add method...");

		Vector v = new Vector(1,2);

		try {
            displaySuccessIfTrue(v.add(new Vector(2,1)).equals(new Vector(3,3)));
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
	}

	public static void testScale() {
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

	}
}

public class VectorTestHarness {
	static int successes = 0;
	static int attempts = 0;

	public static void main(String[] args){
		testAdd();
		testScale();
		testX();
		testY();
	}

	private static void displaySuccessIfTrue(boolean value) {//courtesy of Dondi
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

	public static void testAdd() {

		System.out.println("Testing Vector's add Method...");
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

	}

	public static void testX() {

	}

	public static void testY() {

	}

}

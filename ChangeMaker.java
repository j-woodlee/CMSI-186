public class ChangeMaker {

	public static void main(String[] args){

		try{
			int arg0 = Integer.parseInt(args[0]);

		    int[] arr = getChange(arg0);

		    if(arg0 < 0){
				throw null;
			}

		    for(int a: arr){
			    System.out.println(a);
		    }
		}

		catch(NumberFormatException e){
			System.out.println("Supplied value is not an integer.");
		}

		catch(NullPointerException e) {
			System.out.println("Cannot make change for negative cents.");
		}

	}

    public static int getQuarters(int cents){
		return cents/25;
	}

	public static int getDimes(int cents) {
		return cents/10;
	}

	public static int getNickels(int cents) {
		return cents/5;
	}

	public static int getPennies(int cents) {
		return cents;
	}

	public static int[] getChange(int cents) {
		
		int numQuarters = getQuarters(cents);
		int numDimes = (cents - (numQuarters * 25)) / 10;
		int numNickels = (cents - (numQuarters * 25 + numDimes * 10)) / 5;
		int numPennies = (cents - (numQuarters * 25 + numDimes * 10 + numNickels * 5));

		int[] arr = {numQuarters, numDimes, numNickels, numPennies};

		return arr;

	}


}

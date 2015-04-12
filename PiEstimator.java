public class PiEstimator {
    private Dart d;
    private int numDarts;

    public PiEstimator(int numDarts) {
        d = new Dart();
        this.numDarts = numDarts;
    }

    public static void main(String[] args) {
        PiEstimator p = new PiEstimator(10000);

        try {
            if(args.length > 0) {
                p = new PiEstimator(Integer.parseInt(args[0]));
            }
        } catch(NumberFormatException nfe) {
            System.out.println("Must enter a number. Default value of 10,000 entered.");
        }
        

        System.out.println("start");
        int hits = 0;


        for(int i = 0; i < p.numDarts; i++) {
            System.out.println(p.throwDart() + (p.d.onBoard() ? "in" : "out"));
            if(p.d.onBoard()) {
                hits++;
            }
        }

        System.out.println("end");

        System.out.println("Darts: " + p.numDarts + " Hits: " + hits + " Pi estimate: " + (double)(4*(double)hits)/(double)p.numDarts);
        System.out.println(hits + " darts thrown within the circle.");

    }

    public String throwDart() {
        this.d = new Dart();
        return this.d.x() + " " + this.d.y() + " ";
    }
}

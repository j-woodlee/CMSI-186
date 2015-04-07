public class PiEstimator {
    private double x;
    private double y;

    public PiEstimator() {
        this.x = Math.random() * (Math.random() > .5 ? +1 : -1);
        this.y = Math.random() * (Math.random() > .5 ? +1 : -1);//-1 and 1
    }

    public static void main(String[] args) {
        System.out.println("start");
        int numDarts = 10000;

        if(args.length > 0) {
            numDarts = Integer.parseInt(args[0]);
        }

        PiEstimator p;
        int hits = 0;
        
        for(int i = 0; i < numDarts; i++) {
            p = new PiEstimator();
            System.out.print(p.x + " ");
            System.out.print(p.y + " ");

            if(p.onBoard()) {
                System.out.print("in");
                hits++;
            } else {
                System.out.print("out");
            }
            System.out.println(Math.pow(p.x,2) + Math.pow(p.y,2));
        }
        System.out.println("end");
        System.out.println(numDarts);
        

        System.out.println("Darts: " + numDarts + " Hits: " + hits + " Pi estimate: " + (double)(4*(double)hits)/(double)numDarts);
        System.out.println(hits + " darts thrown within the circle.");
    }

    public boolean onBoard() {
        return Math.pow(this.x,2) + Math.pow(this.y,2) <= 1;
    }
}

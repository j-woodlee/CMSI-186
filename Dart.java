import java.util.Random;

public class Dart {
    private double x; 
    private double y;

    public Dart() {
        this.x = Math.random() * (Math.random() > .5 ? +1 : -1);
        this.y = Math.random() * (Math.random() > .5 ? +1 : -1);
    }

    public Dart(MonteCarloIntegrator mci) {//http://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
        Random r = new Random();
        this.x = mci.getLowerRange() + (mci.getUpperRange() - mci.getLowerRange()) * r.nextDouble();
        this.y = 9.0;
    }

    public static void main(String[] args) {
        MonteCarloIntegrator mci = new MonteCarloIntegrator(10000, 4.5,6.5,new double[10]);
        Dart d = new Dart(mci);
        System.out.println(d);
    }

    public boolean onBoard() {
        return Math.pow(this.x,2) + Math.pow(this.y,2) <= 1;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }
}

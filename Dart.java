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
        double xMax = mci.getUpperRange();
        double xMin = mci.getLowerRange();
        double yMax = mci.findMax() + (0.1 * mci.findMax());
        double yMin = mci.findMin() - (0.1 * mci.findMin());
        this.x = xMin + (xMax - xMin) * r.nextDouble();
        this.y = yMin + (yMax - yMin) * r.nextDouble();
    }

    public static void main(String[] args) {
        MonteCarloIntegrator mci = new MonteCarloIntegrator(10000, 0.5, 1.0, new double[]{9.0, 8.0, 7.0, 6.0});
        Dart d = new Dart(mci);
        System.out.println(d);
    }

    public boolean onUnitCircle() {
        return Math.pow(this.x,2) + Math.pow(this.y,2) <= 1;
    }

    public boolean underFunction(MonteCarloIntegrator mci) {
        if(mci.f(x) > 0 && y > 0 && mci.f(x) >= y) {
            return true;
        } else if(mci.f(x) < 0 && y < 0 && mci.f(x) <= y) {
            return true;
        } else if (mci.f(x) == 0 && y == 0){
            return true;
        }
        return false;
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

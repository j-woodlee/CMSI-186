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
        double xMax = mci.getUpperRangeX();
        double xMin = mci.getLowerRangeX();
        double yMax = mci.getUpperRangeY();
        double yMin = mci.getUpperRangeY();


        if(yMin > 0) {
            yMin = 0;
        }

        if(yMax < 0) {
            yMax = 0;
        }

        double range = yMax - yMin;

        yMax = yMax + range*.1;
        yMin = yMin - range*.1;

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
        double fx = mci.f(x);
        if(fx > 0 && y > 0 && fx >= y) {
            return true;
        } else if(fx < 0 && y < 0 && fx <= y) {
            return true;
        } else if (fx == 0 && y == 0){
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
        return x + " " + y;
    }
}

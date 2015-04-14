public class MonteCarloIntegrator {
    private int numDarts;
    private double lowerRangeX;
    private double upperRangeX;
    private double lowerRangeY;
    private double upperRangeY;
    private double[] coefficients;

    public MonteCarloIntegrator(int numDarts, double lowerRangeX, double upperRangeX, double[] coefficients) {
        this.numDarts = numDarts;
        this.coefficients = coefficients;
        this.lowerRangeX = lowerRangeX;
        this.upperRangeX = upperRangeX;
        this.lowerRangeY = this.findMin();
        this.upperRangeY = this.findMax();
    }

    public static void usage() {
        System.out.println("Usage: <Type of Function> <Zero or more arguments go here, depending on the type of function> <lower bound of range of estimation> <upper bound of range of estimation> <optional total= number of darts, must include 'total='>");
    }

    public static void main(String[] args) {

        double[] arguments = new double[0];

        try {
             arguments = new double[(args[args.length - 1].startsWith("total")) ? args.length - 1 : args.length];

        } catch(ArrayIndexOutOfBoundsException aioobe) {
            usage();
            return;
        }
       
        try {
            int numDarts = !args[args.length - 1].startsWith("total=") ? 10000 : Integer.parseInt(args[args.length - 1].substring(6,args[args.length - 1].length()));

            for(int i = 0; i < arguments.length - 1; i++) {
                arguments[i] = Double.parseDouble(args[i+1]);
            }
            arguments[arguments.length - 1] = (double)numDarts;

        } catch(NumberFormatException nfe) {
            usage();
            return;
        }

        for(double d : arguments) {
             System.out.println(d);
        }

        double[] function = new double[0];
        if(args[0].equals("poly")) {
            int numCoefficients = 0;
            for(int i = arguments.length - 4; i >= 0; i--) {
                numCoefficients++;
            }
            function = new double[numCoefficients];

            for(int i = arguments.length - 4; i >= 0; i--) {
                function[i] = arguments[i];
            }
        } else {
            usage();
            return;
        }

        for(double d : function) {
            System.out.println(d);
        }

        MonteCarloIntegrator mci = new MonteCarloIntegrator((int)arguments[arguments.length - 1], arguments[arguments.length - 3], arguments[arguments.length - 2], function);


        System.out.println("Estimating maximum and minimum...");
        System.out.println("Minimum in range: " + mci.lowerRangeY);
        System.out.println("Maximum in range: " + mci.upperRangeY);
        System.out.println("Final lower bound: " + (mci.upperRangeY - (mci.upperRangeY * 1.1)));
        System.out.println("Final upper bound: " + (mci.upperRangeY + (mci.upperRangeY * .1)));
        System.out.println("start");

        Dart d;

        int hitsAbove = 0;
        int hitsBelow = 0;
        for(int i = 0; i < mci.numDarts; i++) {
            d = new Dart(mci);
            System.out.println(d + " " + (d.underFunction(mci) ? "in" : "out"));
            if(d.underFunction(mci) && d.y() < 0) {
                hitsBelow++;
            } else if(d.underFunction(mci) && d.y() > 0) {
                hitsAbove++;
            } else if(d.underFunction(mci) && d.y() == 0) {
                hitsAbove++;
            }
        }

        System.out.println("end");

        
        double areaRect = (mci.upperRangeX - mci.lowerRangeX) * ((mci.upperRangeY + (mci.upperRangeY * .1)) - (mci.upperRangeY - (mci.upperRangeY * 1.1)));

        double aboveXAxis = areaRect*((double)hitsAbove)/(double)mci.numDarts;
        double belowXAxis = areaRect*((double)hitsBelow)/(double)mci.numDarts;

        System.out.println("Estimate: " + (aboveXAxis - belowXAxis));
    }

    public double f(double x) {
        double sum = 0;
        int j = 0;
        for(int i = coefficients.length - 1; i >= 0; i--) {
            sum += coefficients[j]*Math.pow(x,i);
            j++;
        }
        return sum;
    }

    public double findMax() {//returns y value of the maximum
        double max = f(lowerRangeX);
        for(double i = lowerRangeX; i <= upperRangeX; i += (upperRangeX - lowerRangeX) / 1000000) {
            if(f(i) > max) {
                max = f(i);
            }
        }
        return max;
    }

    public double findMin() {//returns y value of the minimum
        double min = f(lowerRangeX);
        for(double i = lowerRangeX; i <= upperRangeX; i += (upperRangeX - lowerRangeX) / 1000000) {
            if(f(i) < min) {
                min = f(i);
            }
        }
        return min;
    }

    public double getLowerRangeX() {
        return lowerRangeX;
    }

    public double getUpperRangeX() {
        return upperRangeX;
    }

    public double getUpperRangeY() {
        return upperRangeY;
    }

    public double getLowerRangeY() {
        return lowerRangeY;
    }
}

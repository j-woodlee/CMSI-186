public class MonteCarloIntegrator {
    private Dart[] darts;
    private double lowerRange;
    private double upperRange;
    private double[] coefficients;

    public MonteCarloIntegrator(int numDarts, double lowerRange, double upperRange, double[] coefficients) {
        darts = new Dart[numDarts];
        this.lowerRange = lowerRange;
        this.upperRange = upperRange;
        this.coefficients = coefficients;
    }

    public static void usage() {
        System.out.println("Usage: <Type of Function> <Zero or more arguments go here, depending on the type of function> <lower bound of range of estimation> <upper bound of range of estimation> <optional total= number of darts, must include 'total='>");
    }

    public static void main(String[] args) {

        double[] arguments;

        try {
            arguments = new double[(args[args.length - 1].startsWith("total=")) ? args.length - 1 : args.length - 2];//arguments.length is args.length - 2 if there is no total= at the end
        } catch(ArrayIndexOutOfBoundsException aioobe) {
            usage();
            return;
        }
       
        try {
            int numDarts = arguments.length == args.length - 2 ? 10000 : Integer.parseInt(args[args.length - 1].substring(6,args[args.length - 1].length()));

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
        }

        for(double d : function) {
            System.out.println(d);
        }

        MonteCarloIntegrator mci = new MonteCarloIntegrator((int)arguments[arguments.length - 1], arguments[arguments.length - 3], arguments[arguments.length - 2], function);
        System.out.println(mci.f(89));
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
        return 1.0;
    }

    public double findMin() {//returns y value of the minimum
        return 1.0;
    }

    public double getLowerRange() {
        return lowerRange;
    }

    public double getUpperRange() {
        return upperRange;
    }

}

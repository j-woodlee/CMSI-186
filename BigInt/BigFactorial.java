public class BigFactorial {
    public static void main(String[] args) {
        BigInt argument = new BigInt(args[0]);
        BigInt factorial = new BigInt(args[0]);
        BigInt one = new BigInt("1");

        while(argument.isGreaterThan(one)) {
            System.out.println(argument);
            argument = argument.minus(one);
            factorial = factorial.times(argument);
        }
        System.out.println(factorial);
    }
}

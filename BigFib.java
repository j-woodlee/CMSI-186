import java.math.BigInteger;

public class BigFib {
    public static void main(String[] args){

        int iterations = 1000;

        BigInteger num1 = new BigInteger("0");
        BigInteger num2 = new BigInteger("1");
        BigInteger num3 = new BigInteger("0");
        
        while (iterations > 1){//0, 1, 1, 2, 3, 5, 8, 13
            System.out.println(num3);

            if(num3.equals(new BigInteger("1"))){
                System.out.println(num3);
            }

            num3 = num1.add(num2);

            num1 = num2;
            num2 = num3;

            iterations--;
        }
    }
}

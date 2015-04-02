
public class BigFib {
    public static void main(String[] args){

        int iterations = 100;

        BigInt num1 = new BigInt("0");
        BigInt num2 = new BigInt("1");
        BigInt num3 = new BigInt("0");
        
        while (iterations > 1){//0, 1, 1, 2, 3, 5, 8, 13
            System.out.println(num3);

            if(num3.equals(new BigInt("1"))){
                System.out.println(num3);
            }

            num3 = num1.plus(num2);

            num1 = num2;
            num2 = num3;

            iterations--;
        }
    }
}

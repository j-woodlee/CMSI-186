public class BigInt {
    boolean[] bits;
    byte sign;

    public BigInt() {
        bits = new boolean[0];
        sign = 0;
    }

    public BigInt(String number) {
        bits = BigInt.decimalToBinary(number);

    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        decimalToBinary(args[0]);
    }

    public static boolean[] decimalToBinary(String decNum) {
        byte[] digits = new byte[decNum.length()];
        for(int i = 0; i < digits.length; i++){
            digits[i] = Byte.parseByte(decNum.substring(0,1));
        }


        return new boolean[10];

    }

    public static int[] divideByTwo(int[] number){
        int dividend = number[0];
        System.out.println(dividend);

        while (true) {
            break;
        }
        return new int[1];
    }
    
}

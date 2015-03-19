import java.math.BigInteger;

public class BigInt {
    boolean[] bits;//true = 1, false = 0, binary representation
    String number;//decimal representation
    byte sign;//-1, 0, 1

    public BigInt() {
        this.bits = new boolean[] {false};
        this.number = "0";
        this.sign = 0;
    }

    public BigInt(String number) {

        number = number.replaceAll("\\s+","");// replace all blank spaces with an empty string
        number = removeExtraZeroes(number);//remove unnecessary zeroes from the number(zeroes in the front)

        if (number.substring(0,1).equals("0")) {
            this.sign = 0;
        } else if (number.substring(0,1).equals("-")) {
            this.sign = -1;
            number = number.substring(1, number.length());
        } else if (number.substring(0,1).equals("+")) {
            this.sign = 1;
            number = number.substring(1, number.length());
        } else {
            this.sign = 1;
        }

        //System.out.println("number: " + number);
        this.number = number;

        bits = BigInt.decimalToBinary(number);
    }

    public static void main(String[] args) {
        System.out.println("args[0]: " + args[0]);
       // BigInt b = new BigInt(args[0]);
        //System.out.println(b.bits);
        //System.out.println(b.sign);

        //BigInteger a = new BigInteger("234242342342342342342343242342349879879079786876856567576475465463543543298989892849283984928394892834928349829384923849823498293");
        
        //System.out.println(b);
        //System.out.println(divideByTwo("234242342342342342342343242342349879879079786876856567576475465463543543298989892849283984928394892834928349829384923849823498293"));
        //System.out.println(a.divide(new BigInteger("2")));
        System.out.println(divideByTwo("1"));
        System.out.println(divideByTwo("2"));
        System.out.println(divideByTwo("3"));
        System.out.println(divideByTwo("4"));
        System.out.println(divideByTwo("5"));
        System.out.println(divideByTwo("6"));
        System.out.println(divideByTwo("7"));
        System.out.println(divideByTwo("8"));
        System.out.println(divideByTwo("9"));
        System.out.println(divideByTwo("10"));
        System.out.println(divideByTwo("11"));
        System.out.println(divideByTwo("16"));
        System.out.println(divideByTwo("20"));


    }

    public static boolean[] decimalToBinary(String decNum) {

        String result = "";
        
        while(Integer.parseInt(decNum.substring(decNum.length() - 1, decNum.length())) > 0) {

            if(Integer.parseInt(decNum.substring(decNum.length() - 1, decNum.length())) % 2 == 0) {
                result += "0";
            } else {
                result += "1";
            }

            decNum = divideByTwo(decNum);
        }

        result = new StringBuilder(result).reverse().toString();

        boolean[] bits = new boolean[result.length()];

        for(int i = 0; i < bits.length; i++) {
            if(result.substring(i, i + 1) == "1") {
                bits[i] = true;
            } else {
                bits[i] = false;
            }
        }

        return bits;
    }

    public static String removeExtraZeroes(String str) {
        boolean isNegative = false;
        while ((str.substring(0,1).equals("0") || str.substring(0,1).equals("-")) && str.length() > 1) {//replace insignificant zeroes with an empty string
           if(str.substring(0,1).equals("-")){
               isNegative = true;
           }
           str = str.substring(1, str.length());
        }

        if(isNegative) {
            str = "-" + str.substring(0,str.length());
        }
        return str;
    }

    public static String divideByTwo(String nmbr) {
        int[] num = new int[nmbr.length()];
        for(int i = 0; i < num.length; i++){
            num[i] = Integer.parseInt(nmbr.substring(i, i + 1));
        }

        int dividend = num[0];

        String result = "";

        int i = 0;
        while(i < num.length) {
            if(dividend >= 2) {
                result += (dividend / 2);
                dividend = dividend - ((dividend / 2) * 2);
                i++;
            } else if(dividend < 2) {
                dividend = dividend * 10 + num[i];
            }
        }
        return result;
    }

    public boolean isGreaterThan(BigInt b) {
        throw new UnsupportedOperationException();
    }

    public boolean isLessThan(BigInt b) {
        throw new UnsupportedOperationException();
    }

    public BigInt minus(BigInt subtrahend) {
        throw new UnsupportedOperationException();
    }

    public BigInt plus(BigInt addend) {
        throw new UnsupportedOperationException();
    }

    public BigInt div(BigInt divisor) {
        throw new UnsupportedOperationException();
    }

    public BigInt mod(BigInt divisor) {
        throw new UnsupportedOperationException();
    }

    public BigInt times(BigInt factor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        BigInt other = (BigInt)obj;

        return this.number.equals(other.number) && this.sign == other.sign;
    }

    @Override
    public String toString(){
        if(sign == 1){
            return "+" + number;
        } else if (sign == -1) {
            return "-" + number;
        } else {
            return number;
        }
    }
}

import java.math.BigInteger;

public class BigInt {
    boolean[] bits;//true = 1, false = 0, binary representation
    String number;//decimal representation
    short sign;//-1, 0, 1

    public BigInt() {
        this("0");
    }

    public BigInt(String number) {//remember to deal with edge cases

        number = number.replaceAll("\\s+","");// replace all blank spaces with an empty string, from http://stackoverflow.com/questions/13209866/java-replace-method-replacing-with-empty-character
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
        //System.out.println(divideByTwo("1"));
        //System.out.println(divideByTwo("2000000023492384072098371092834671234"));
        //System.out.println(new BigInteger("13083274982734987234").divide(new BigInteger("2")).toString());
        //System.out.println(BigInt.divideByTwo("13083274982734987234"));
        boolean[] asdf = BigInt.decimalToBinary("23897"); 

        for(boolean b: asdf) {
            //System.out.println(b);
            System.out.print( b ? 1 : 0);
        }
        //System.out.println(BigInt.decimalToBinary("23897"));



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
            if(result.substring(i, i + 1).equals("1")) {
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

    public static String divideByTwo(String nmbr) {//will change later, but works as is
        String result = "";

        int i = nmbr.length();
        String current = "";
        String before = "";

        while(true) {

            current = nmbr.substring(i-1,i);
            
            if(i-1 == 0) {
                if(current.equals("0") || current.equals("1")) {
                    result += "0";
                } else if(current.equals("2") || current.equals("3")) {
                    result += "1";
                } else if(current.equals("4") || current.equals("5")) {
                    result += "2";
                } else if(current.equals("6") || current.equals("7")) {
                    result += "3";

                } else if(current.equals("8") || current.equals("9")) {
                    result += "4";
                }
                break;
            }

            before = nmbr.substring(i - 2, i-1);

            if(current.equals("0") || current.equals("1")){
                if(Integer.parseInt(nmbr.substring(i - 2, i-1)) % 2 == 0) {
                    result += "0";
                } else {
                    result += "5";
                }
            } else if(current.equals("2") || current.equals("3")) {
                if(Integer.parseInt(nmbr.substring(i - 2, i-1) ) % 2 == 0) {
                    result += "1";
                } else {
                    result += "6";
                }
            } else if(current.equals("4") || current.equals("5")) {
                if(Integer.parseInt(nmbr.substring(i - 2, i-1))  % 2 == 0) {
                    result += "2";
                } else {
                    result += "7";
                }
            } else if(current.equals("6") || current.equals("7")) {
                if(Integer.parseInt(nmbr.substring(i - 2, i-1) ) % 2 == 0) {
                    result += "3";
                } else {
                    result += "8";
                }
            } else if(current.equals("8") || current.equals("9")) {
                if(Integer.parseInt(nmbr.substring(i - 2, i-1))  % 2 == 0) {
                    result += "4";
                } else {
                    result += "9";
                }
            }

            i--;
        }

        result = new StringBuilder(result).reverse().toString();
        result = removeExtraZeroes(result);
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
    public boolean equals(Object obj) {//inspired by Dondi
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

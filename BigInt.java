import java.math.BigInteger;

public class BigInt {
    boolean[] bits;//true = 1, false = 0, binary representation
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

        bits = BigInt.decimalToBinary(number);
    }

    public static void main(String[] args) {
        


    }

    public static boolean[] decimalToBinary(String decNum) {

        String result = "";
        int lastDigit = Integer.parseInt(decNum.substring(decNum.length() - 1, decNum.length()));

        do {
            lastDigit = Integer.parseInt(decNum.substring(decNum.length() - 1, decNum.length()));
            if(lastDigit % 2 == 0) {
                result += "0";
            } else {
                result += "1";           
            }
            
            decNum = divideByTwo(decNum);
        } while(!decNum.equals("0"));

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
           if(str.substring(0,1).equals("-")) {
               isNegative = true;
           }
           str = str.substring(1, str.length());
        }

        if(isNegative) {
            str = "-" + str.substring(0,str.length());
        }
        return str;
    }

    public static String divideByTwo(String nmbr) {//will change later for less code, but works as is
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

    public static String doubleDecimalString(String s) {//adds a decimal number to itself
        String sum = "";
        int partialSum = 0;

        int currentDigit = Integer.parseInt(s.substring(s.length() - 1, s.length()));
        partialSum = currentDigit + currentDigit;

        int i = s.length() - 1;

        int carriedVal = 0;
        String strPartialSum = "";
        int pSumC = 0;

        while(i >= 0) {
            currentDigit = Integer.parseInt(s.substring(i, i + 1));
            partialSum = currentDigit + currentDigit;
            pSumC = currentDigit + currentDigit;
            if(partialSum < 10) {
                partialSum += carriedVal;
                sum += partialSum;
                carriedVal = 0;
            } else {
                partialSum += carriedVal;
                strPartialSum = Integer.toString(partialSum);
                carriedVal = 1;
                partialSum = Integer.parseInt(strPartialSum.substring(1,2));
                sum += partialSum;
            }

            if (i == 0 && pSumC > 9) {
                sum += "1";
            }

            i--;
        }



        sum = new StringBuilder(sum).reverse().toString();
        return sum;

    }

    public static String addOne(String s) {//adds one to a positive decimal number
        int lastDigit = Integer.parseInt(s.substring(s.length() - 1, s.length()));

        if(lastDigit != 9) {
            lastDigit++;
            s = s.substring(0, s.length() - 1) + lastDigit;
        } else {
            int count = s.length();
            for(int i = s.length()-1; i >= 0; i--) {
                if(s.substring(i,i+1).equals("9")) {
                    count--;//by the end of this loop count is the index of the nine furthest in from the right, example: in 34999 count would be 2 at the end of the loop 1999999
                }
            }//s.length() - count  is the number of 9's

            String endZeroes = "";

            for(int i = 0; i < (s.length() - count); i++) {
                endZeroes += "0";
            }

            if(count == 0) {//count == 0 means that the number is constructed of all 9's
                s = "1" + endZeroes;
            } else {
                int plusOneDigit = Integer.parseInt(s.substring(count-1, count));

                plusOneDigit++;

                s = s.substring(0, count-1) + plusOneDigit + endZeroes;
            }

           }
           return s;
    }

    public boolean isGreaterThan(BigInt n) {//test for signs
        if(this.bits.length > n.bits.length) {
            return true;
        } else if (this.bits.length < n.bits.length) {
            return false;
        }

        return false;
    }

    public boolean isLessThan(BigInt n) {
        if(this.bits.length < n.bits.length) {
            return true;
        } else if (this.bits.length > n.bits.length) {
            return false;
        }
        return false;
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

        boolean signsEqual = this.sign == other.sign ? true : false;
        boolean componentsEqual = false;

        int count = 0;

        if (this.bits.length == other.bits.length) {
            for(int i = 0; i < this.bits.length; i++) {
                if(this.bits[i] == other.bits[i]) {
                    count++;
                }
            }
            componentsEqual = count == this.bits.length ? true : false;
        }

        return signsEqual && componentsEqual;
    }

    @Override
    public String toString() {
        return "";

    }
}

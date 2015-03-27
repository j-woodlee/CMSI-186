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

    public static String binaryToDecimal(boolean[] binary) {
        
        String number = "0";

        int i = 0;
        while(i < binary.length) {
            number = doubleDecimalString(number);
            if (binary[i]) {//if the left bit is 1
                number = addOne(number);
            }
            i++;
        }
        return number;
    }

    public boolean isGreaterThan(BigInt n) {//test for signs
        
        if(this.sign == 1 && (n.sign == -1 || n.sign == 0)) {
            return true;
        } else if(n.sign == 1 && (this.sign == -1 || this.sign == 0)) {
            return false;
        }//we now know the signs are equal

        boolean absValGreater = false;

        if(this.bits.length > n.bits.length) {
            absValGreater = true;
        } else if (this.bits.length < n.bits.length) {
            absValGreater = false;
        } else {//n.bits.length == this.bits.length
            int count = 0;
            for(int i = 0; i < this.bits.length; i++) {
                if(this.bits[i] && !n.bits[i]) {
                    absValGreater = true;
                    break;
                } else if(!this.bits[i] && n.bits[i]) {
                    break;
                }
                count = this.bits[i] == n.bits[i] ? count + 1 : count;
            }
            if (count == this.bits.length) {//they are equal
                return false;
            }
        }

        return this.sign == 1 ? absValGreater : !absValGreater; //this.sign == 1 implies n.sign == 1, also this.sign == -1 implies n.sign == -1
    }

    public boolean isLessThan(BigInt n) {
        return !this.isGreaterThan(n) && !this.equals(n);
    }

    public static void main(String[] args) {
        BigInt b = new BigInt("1296");
        System.out.println(b.plus(new BigInt("2343")));
        System.out.println("10100010000");
        System.out.println("100100100111");
    }

    public BigInt plus(BigInt addend) {
        if(this.bits.length < addend.bits.length) {
            return addend.plus(this);
        }

        boolean[] addendBits = new boolean[this.bits.length];

        for(int i = 0; i < addend.bits.length; i++) {
            addendBits[(this.bits.length - addend.bits.length) + i] = addend.bits[i];
        }
        addend.bits = addendBits;

        BigInt sum = new BigInt();
        sum.bits = new boolean[this.bits.length + 1];

        if((this.sign == addend.sign) || (this.sign == 0 && addend.sign == 1) || (addend.sign == 0 && this.sign == 1)) {//if both signs are zero, if both signs are positive, or if one of the signs is zero and the other ispositive
            //add algorithm
            boolean carry = false;
            for(int i = this.bits.length - 1; i >= 0; i--) {
                if(!this.bits[i] && !addend.bits[i]) {// 0 and 0
                    sum.bits[i + 1] = carry ? true : false;
                    carry = false;
                } else if(this.bits[i] != addend.bits[i]) {//0 and 1
                    sum.bits[i + 1] = carry ? false : true;
                } else {//1 and 1
                     sum.bits[i + 1] = carry ? true : false;
                     carry = true;
                }
            }

            if(this.sign == -1) {
                sum.sign = -1;
            } else if(this.sign == 0 && addend.sign == 0) {
                sum.sign = 0;
            } else {
                sum.sign = 1;
            }

            if(carry) {
                sum.bits[0] = true;
            } else {
                boolean[] newSum = new boolean[sum.bits.length - 1];
                for(int i = 0; i < newSum.length; i++) {
                    newSum[i] = sum.bits[i + 1];
                }
                sum.bits = newSum;
            }

        } else {// if one of the signs is negative and one of them is positive
            //subtract algorithm, this - addend

            if(this.isAbsValGreaterThan(addend)) {
                sum.bits = new boolean[this.bits.length];
                boolean top;
                boolean borrow = false;
                
                for(int i = this.bits.length - 1; i >= 0; i--) {
                    top = this.bits[i];
                    if(borrow) {
                        if(top) {//top == 1
                            top = false;
                            borrow = false;
                        } else {
                            top = true;
                        }
                    }
                    if(!top && !addend.bits[i]) {//0 and 0
                        sum.bits[i] = false;
                    } else if(!top && addend.bits[i]) { //0 and 1
                        sum.bits[i] = true;
                        borrow = true;
                    } else if(top && !addend.bits[i]) { // 1 and 0
                        sum.bits[i] = true;
                    } else if(top && addend.bits[i]) { // 1 and 1
                        sum.bits[i] = false;
                    }
                }
            } else if (addend.isAbsValGreaterThan(this)) {
                sum = addend.plus(this);
            } else {
                return new BigInt();
            }

            if(this.isGreaterThan(addend)) {
                sum.sign = 1;
            } else if(addend.isGreaterThan(this)) {
                sum.sign = -1;
            }
        }

        return sum;
    }

    public boolean isAbsValGreaterThan(BigInt b) {
        if((this.sign == 1 || this.sign == 0) && (this.sign == 0 || b.sign == 1)) {// 1 and 1
            return this.isGreaterThan(b);
        } else if(this.sign == -1 && (b.sign == 1 || b.sign == 0)) {// -1 and 1
            BigInt thisCopy = new BigInt(this.toString());
            thisCopy.sign = 1;
            return thisCopy.isGreaterThan(b);
        } else if((this.sign == 1 || this.sign == 0) && b.sign == -1) {// 1 and -1
            BigInt bCopy = new BigInt(b.toString());
            bCopy.sign = 1;
            return this.isGreaterThan(bCopy);
        } else {// sign of both == -1
            BigInt thisCopy = new BigInt(this.toString());
            BigInt bCopy = new BigInt(b.toString());
            thisCopy.sign = 1;
            bCopy.sign = 1;
            return thisCopy.isGreaterThan(bCopy);
        }
    }

    public BigInt minus(BigInt subtrahend) {
        subtrahend.sign *= -1;
        return this.plus(subtrahend);
    }

    public BigInt div(BigInt divisor) {
        throw new UnsupportedOperationException();
    }

    public BigInt mod(BigInt divisor) {
        throw new UnsupportedOperationException();
    }

    public BigInt times(BigInt factor) {//precondition: this.bits[0] and factor.bits[0] is always true
        BigInt product = new BigInt();
        if(this.sign == 0 || factor.sign == 0) {
            return product;
        } 
        boolean[][] column1 = new boolean[this.bits.length][];
        boolean[][] column2 = new boolean[this.bits.length][];

        int factorLength = factor.bits.length;
        int thisLength = this.bits.length;
        for(int i = 0; i < this.bits.length; i++) {
            column2[i] = new boolean[factorLength];
            column1[i] = new boolean[thisLength];

            for(int j = 0; j < factor.bits.length; j++) {
                column2[i][j] = factor.bits[j];
            }

            for(int j = 0; j < thisLength; j++) {
                column2[i][j] = this.bits[j];
            }

            factorLength++;
            thisLength--;
        }

        for(int i = 0; i < this.bits.length; i++) {
            if(!column1[i][column1[i].length - 1]) {//number is even if last element is false
                product = product.plus(new BigInt(binaryToDecimal(column1[i])).plus(new BigInt(binaryToDecimal(column2[i]))));
            }
        }

        if(this.sign == factor.sign) {
            product.sign = 1;
            return product;
        }
        product.sign = -1;
        return product;
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

        boolean signsEqual = this.sign == other.sign;
        boolean componentsEqual = false;

        int count = 0;


        if (this.bits.length == other.bits.length) {
            for(int i = 0; i < this.bits.length; i++) {
                if(this.bits[i] == other.bits[i]) {
                    //System.out.println("this bits: " + this.bits[i] + " other bits: " + other.bits[i]);
                    count++;
                }
            }
            componentsEqual = count == this.bits.length;
        }

        return signsEqual && componentsEqual;
    }

    @Override
    public String toString() {
        if(sign == 0) {
            return "0";
        }
        return sign == 1 ? "+" + binaryToDecimal(this.bits) : "-" + binaryToDecimal(this.bits);
    }
}

import java.math.BigInteger;
public class BigIntTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        // Feel free to add more cases to these.
        test_Constructor();
        test_toString();
        test_Equals();
        test_Addition();
        test_DivideByTwo();
        test_IsGreaterThan();
        test_IsLessThan();
        test_RemoveExtraZeroes();
        test_DecimalToBinary();
        test_AddOne();
        test_DoubleDecimalString();
        test_binaryToDecimal();
        test_IsAbsValGreaterThan();
        
        // You should implement:
        //   test_isGreaterThan
        //   test_isLessThan
        //   test_Subtraction
        //   test_Multiplication
        //   test_IntegerDivision
        //   test_Modulo

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void test_IsAbsValGreaterThan() {
        System.out.println("Testing IsAbsValGreaterThan...");
        BigInt b1 = new BigInt("-1349814");
        BigInt b2 = new BigInt("-189414");

        try {
            displaySuccessIfTrue(b1.isAbsValGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-1");
        b2 = new BigInt("1");

        try {
            displaySuccessIfTrue(!b1.isAbsValGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-1");
        b2 = new BigInt("-5");

        try {
            displaySuccessIfTrue(!b1.isAbsValGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("1313213");
        b2 = new BigInt("34728748234234782374");

        try {
            displaySuccessIfTrue(!b1.isAbsValGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-11234124");
        b2 = new BigInt("-5123471920342");

        try {
            displaySuccessIfTrue(!b1.isAbsValGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("0");
        b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(!b1.isAbsValGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-1");
        b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(b1.isAbsValGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("0");
        b2 = new BigInt("1231927");

        try {
            displaySuccessIfTrue(!b1.isAbsValGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_Constructor() {
        System.out.println("Testing constructors...");

        try {
            displaySuccessIfTrue("+1".equals(new BigInt("1 ").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+1".equals(new BigInt("  +1").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-1".equals(new BigInt("-1  ").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new BigInt("0").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new BigInt().toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+314159265358979323846264338327950288"
                    .equals(new BigInt("314159265358979323846264338327950288").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+314159265358979323846264338327950288"
                    .equals(new BigInt("+314159265358979323846264338327950288").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-314159265358979323846264338327950288"
                    .equals(new BigInt("-314159265358979323846264338327950288").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            new BigInt("a");
            displaySuccessIfTrue(false);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }

    }

    private static void test_toString() {
        System.out.println("Testing toString...");

        try {
            displaySuccessIfTrue("+9234013274012419836418634983459547689126439817263478157836453178654"
                    .equals(new BigInt("9234013274012419836418634983459547689126439817263478157836453178654").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+123456789123456789"
                    .equals(new BigInt("123456789123456789").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("+123456789123456789"
                    .equals(new BigInt("000123456789123456789").toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_Equals() {
        System.out.println("Testing equals...");

        try {
            displaySuccessIfTrue(new BigInt("123456789123456789")
                    .equals(new BigInt("123456789123456789")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new BigInt("123456789123456789")
                    .equals(new BigInt("333"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new BigInt("123456789123456789")
                    .equals(new BigInt("-123456789123456789"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("123456789123456789")
                    .equals(new BigInt("000123456789123456789")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_Addition() {
        System.out.println("Testing addition...");

        

        try {
            displaySuccessIfTrue(new BigInt("0").equals(new BigInt("0").plus(new BigInt("0"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        

        try {
            displaySuccessIfTrue(new BigInt("1").equals(new BigInt("0").plus(new BigInt("1"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        

        try {
            displaySuccessIfTrue(new BigInt("1").equals(new BigInt("1").plus(new BigInt("0"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        

        try {
            displaySuccessIfTrue(new BigInt("2").equals(new BigInt("1").plus(new BigInt("1"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        

        try {
            displaySuccessIfTrue(new BigInt("1000").equals(new BigInt("1").plus(new BigInt("999"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        

        try {
            displaySuccessIfTrue(new BigInt("1000").equals(new BigInt("123").plus(new BigInt("877"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }


        try {
            displaySuccessIfTrue(new BigInt("-999").equals(new BigInt("-123").plus(new BigInt("-876"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }


        try {
            displaySuccessIfTrue(new BigInt("-1000").equals(new BigInt("-123").plus(new BigInt("-877"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        System.out.println(new BigInt("+3000").plus(new BigInt("-4000")));

        try {
            displaySuccessIfTrue(new BigInt("-1000").equals(new BigInt("+3000").plus(new BigInt("-4000"))));//101110111000 + -111110100000
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        System.out.println(new BigInt("-4000").plus(new BigInt("+3000")));

        try {
            displaySuccessIfTrue(new BigInt("-1000").equals(new BigInt("-4000").plus(new BigInt("+3000"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        System.out.println(new BigInt("-1").plus(new BigInt("+1")));

        try {
            displaySuccessIfTrue(new BigInt("0").equals(new BigInt("-1").plus(new BigInt("+1"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        System.out.println(new BigInt("+1").plus(new BigInt("-1")));

        try {
            displaySuccessIfTrue(new BigInt("0").equals(new BigInt("+1").plus(new BigInt("-1"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        System.out.println(new BigInt("-1").plus(new BigInt("+11")));

        try {
            displaySuccessIfTrue(new BigInt("10").equals(new BigInt("-1").plus(new BigInt("+11"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        System.out.println(new BigInt("12").plus(new BigInt("-2")));

        try {
            displaySuccessIfTrue(new BigInt("10").equals(new BigInt("+12").plus(new BigInt("-2"))));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        try {
            BigInt x = new BigInt("+12354");
            displaySuccessIfTrue(new BigInt("24708").equals(x.plus(x)));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(("+" + (new java.math.BigInteger("123456789123456789")))
                    .equals(new BigInt("123456789123456789").plus(new BigInt()).toString()));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new BigInt("123456789123456789")
                    .plus(new BigInt("-123456789123456789")).toString()));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("2934097831972391728347612783641927841983569834695")
                    .add(new java.math.BigInteger("9234013274012419836418634983459547689126439817263478157836453178654"));
            displaySuccessIfTrue(("+" + expected).equals(new BigInt("2934097831972391728347612783641927841983569834695")
                    .plus(new BigInt("9234013274012419836418634983459547689126439817263478157836453178654")).toString()));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("000123456789123456789")
                    .add(new java.math.BigInteger("000123456789123456789"));
            displaySuccessIfTrue(("+" + expected).equals(new BigInt("000123456789123456789")
                    .plus(new BigInt("000123456789123456789")).toString()));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("888888888888888888")
                    .add(new java.math.BigInteger("-999999999999999999"));
            displaySuccessIfTrue(expected.toString().equals(new BigInt("888888888888888888")
                    .plus(new BigInt("-999999999999999999")).toString()));
        } catch(Exception e) {
            e.printStackTrace();
            displaySuccessIfTrue(false);
        }

    }

    public static void test_DivideByTwo() {
        System.out.println("Testing DivideByTwo...");

        try {
            displaySuccessIfTrue(new BigInteger("13083274982734987234").divide(new BigInteger("2")).toString().equals(BigInt.divideByTwo("13083274982734987234")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").divide(new BigInteger("2")).toString().equals(BigInt.divideByTwo("0")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("10").divide(new BigInteger("2")).toString().equals(BigInt.divideByTwo("10")));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_RemoveExtraZeroes() {
        System.out.println("Testing removeExtraZeroes...");


        String s1 = "123213";
        String s2 = "0000123213";

        s2 = BigInt.removeExtraZeroes(s2);
    
        try {
            displaySuccessIfTrue(s1.equals(s2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s1 = "1";
        s2 = "00000000000000000000000000000000001";
        s1 = BigInt.removeExtraZeroes(s1);
        s2 = BigInt.removeExtraZeroes(s2);

        try {
            displaySuccessIfTrue(s1.equals(s2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s1 = "00000000000000000000001";
        s2 = "00000000000000000000000000000000001";
        s1 = BigInt.removeExtraZeroes(s1);
        s2 = BigInt.removeExtraZeroes(s2);
        

        try {
            displaySuccessIfTrue(s1.equals(s2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s1 = "01";
        s2 = "00000000000000000000000000000000001";
        s1 = BigInt.removeExtraZeroes(s1);
        s2 = BigInt.removeExtraZeroes(s2);

        try {
            displaySuccessIfTrue(s1.equals(s2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_DecimalToBinary() {
        System.out.println("Testing decimalToBinary...");

        boolean[] bools = BigInt.decimalToBinary("123947812938471234");
        String s1 = "";
        for(boolean bool: bools) {
            s1 = s1 + (bool ? "1": "0");
        }

        try {
            displaySuccessIfTrue(s1.equals("110111000010110011110000100010000111000100101011101000010"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        bools = BigInt.decimalToBinary("0");
        s1 = "";
        for(boolean bool: bools) {
            s1 = s1 + (bool ? "1": "0");
        }

        try {
            displaySuccessIfTrue(s1.equals("0"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        bools = BigInt.decimalToBinary("10");
        s1 = "";
        for(boolean bool: bools) {
            s1 = s1 + (bool ? "1": "0");
        }

        try {
            displaySuccessIfTrue(s1.equals("1010"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        bools = BigInt.decimalToBinary("10000000000000");
        s1 = "";
        for(boolean bool: bools) {
            s1 = s1 + (bool ? "1": "0");
        }

        try {
            displaySuccessIfTrue(s1.equals("10010001100001001110011100101010000000000000"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        bools = BigInt.decimalToBinary("10002346128734691234");
        s1 = "";
        for(boolean bool: bools) {
            s1 = s1 + (bool ? "1": "0");
        }

        try {
            displaySuccessIfTrue(s1.equals("1000101011001111011110001100111100110011101111000001111110100010"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        bools = BigInt.decimalToBinary("9");
        s1 = "";
        for(boolean bool: bools) {
            s1 = s1 + (bool ? "1": "0");
        }

        try {
            displaySuccessIfTrue(s1.equals("1001"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_AddOne() {
        System.out.println("Testing addOne...");

        String s = "123456789";

        try {
            displaySuccessIfTrue(BigInt.addOne(s).equals("123456790"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "0";
        

        try {
            displaySuccessIfTrue(BigInt.addOne(s).equals("1"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "9";
        

        try {
            displaySuccessIfTrue(BigInt.addOne(s).equals("10"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "10";
        

        try {
            displaySuccessIfTrue(BigInt.addOne(s).equals("11"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "19";
        

        try {
            displaySuccessIfTrue(BigInt.addOne(s).equals("20"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "999";
        

        try {
            displaySuccessIfTrue(BigInt.addOne(s).equals("1000"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "6875764857865876578658";
        

        try {
            displaySuccessIfTrue(BigInt.addOne(s).equals("6875764857865876578659"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "69999999999";
        

        try {
            displaySuccessIfTrue(BigInt.addOne(s).equals("70000000000"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "1";
        

        try {
            displaySuccessIfTrue(BigInt.addOne(s).equals("2"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    private static void test_DoubleDecimalString() {
        System.out.println("Testing doubleDecimalString...");

        String s = "1";
        
        try {
            displaySuccessIfTrue(BigInt.doubleDecimalString(s).equals("2"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "10000";
        
        try {
            displaySuccessIfTrue(BigInt.doubleDecimalString(s).equals("20000"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "1";
        
        try {
            displaySuccessIfTrue(BigInt.doubleDecimalString(s).equals("2"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "99";
        
        try {
            displaySuccessIfTrue(BigInt.doubleDecimalString(s).equals("198"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

       
        BigInteger b = new BigInteger("29384709182734098123740981234");
        
        s = "29384709182734098123740981234";
        
        try {
            displaySuccessIfTrue(BigInt.doubleDecimalString(s).equals("58769418365468196247481962468"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b = new BigInteger("12938461230412341234123412341234");
        

        s = "12938461230412341234123412341234";
        
        try {
            displaySuccessIfTrue(BigInt.doubleDecimalString(s).equals("25876922460824682468246824682468"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        s = "0";
        
        try {
            displaySuccessIfTrue(BigInt.doubleDecimalString(s).equals("0"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_binaryToDecimal() {
        System.out.println("Testing binaryToDecimal...");

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {true, false, true, false}).equals("10"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {true, false, true, false, true, false}).equals("42"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {true, true, true, false}).equals("14"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {true, true, true, true}).equals("15"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {true}).equals("1"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {false}).equals("0"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {true, true}).equals("3"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {false, false}).equals("0"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {true, true, true, true, true, true, false}).equals("126"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInt.binaryToDecimal(new boolean[] {true, true, true, true, true, true, true, true, false}).equals("510"));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }


    private static void test_IsGreaterThan() {
        System.out.println("Testing isGreaterThan...");

        BigInt b1 = new BigInt("1");
        BigInt b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(b1.isGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("12345");
        b2 = new BigInt("12345");

        try {
            displaySuccessIfTrue(!b1.isGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("123455");
        b2 = new BigInt("12345");

        try {
            displaySuccessIfTrue(b1.isGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("0000123");
        b2 = new BigInt("99999999999");

        try {
            displaySuccessIfTrue(b2.isGreaterThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("0");
        b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(!b1.isGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("12");
        b2 = new BigInt("13");

        try {
            displaySuccessIfTrue(b2.isGreaterThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-123123");
        b2 = new BigInt("3113413");

        try {
            displaySuccessIfTrue(b2.isGreaterThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-123123");
        b2 = new BigInt("-3113413");

        try {
            displaySuccessIfTrue(b1.isGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-1");
        b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(b2.isGreaterThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-1");
        b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(!b1.isGreaterThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

    private static void test_IsLessThan() {
        System.out.println("Testing isLessThan...");

        BigInt b1 = new BigInt("1");
        BigInt b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(b2.isLessThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("12345");
        b2 = new BigInt("12345");

        try {
            displaySuccessIfTrue(!b2.isLessThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("123455");
        b2 = new BigInt("12345");

        try {
            displaySuccessIfTrue(b2.isLessThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("0000123");
        b2 = new BigInt("99999999999");

        try {
            displaySuccessIfTrue(b1.isLessThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("0");
        b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(!b2.isLessThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("12");
        b2 = new BigInt("13");

        try {
            displaySuccessIfTrue(b1.isLessThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-123123");
        b2 = new BigInt("3113413");

        try {
            displaySuccessIfTrue(b1.isLessThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-123123");
        b2 = new BigInt("-3113413");

        try {
            displaySuccessIfTrue(b2.isLessThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-1");
        b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(!b2.isLessThan(b1));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        b1 = new BigInt("-1");
        b2 = new BigInt("0");

        try {
            displaySuccessIfTrue(b1.isLessThan(b2));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
    }

}

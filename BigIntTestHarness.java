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
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("1").equals(new BigInt("0").plus(new BigInt("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("1").equals(new BigInt("1").plus(new BigInt("0"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("2").equals(new BigInt("1").plus(new BigInt("1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("1000").equals(new BigInt("1").plus(new BigInt("999"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("1000").equals(new BigInt("123").plus(new BigInt("877"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("-999").equals(new BigInt("-123").plus(new BigInt("-876"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("-1000").equals(new BigInt("-123").plus(new BigInt("-877"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("-1000").equals(new BigInt("+3000").plus(new BigInt("-4000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("-1000").equals(new BigInt("-4000").plus(new BigInt("+3000"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("0").equals(new BigInt("-1").plus(new BigInt("+1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("0").equals(new BigInt("+1").plus(new BigInt("-1"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("10").equals(new BigInt("-1").plus(new BigInt("+11"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInt("10").equals(new BigInt("+12").plus(new BigInt("-2"))));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInt x = new BigInt("+12354");
            displaySuccessIfTrue(new BigInt("24708").equals(x.plus(x)));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(("+" + (new java.math.BigInteger("123456789123456789")))
                    .equals(new BigInt("123456789123456789").plus(new BigInt()).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new BigInt("123456789123456789")
                    .plus(new BigInt("-123456789123456789")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("2934097831972391728347612783641927841983569834695")
                    .add(new java.math.BigInteger("9234013274012419836418634983459547689126439817263478157836453178654"));
            displaySuccessIfTrue(("+" + expected).equals(new BigInt("2934097831972391728347612783641927841983569834695")
                    .plus(new BigInt("9234013274012419836418634983459547689126439817263478157836453178654")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("000123456789123456789")
                    .add(new java.math.BigInteger("000123456789123456789"));
            displaySuccessIfTrue(("+" + expected).equals(new BigInt("000123456789123456789")
                    .plus(new BigInt("000123456789123456789")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("888888888888888888")
                    .add(new java.math.BigInteger("-999999999999999999"));
            displaySuccessIfTrue(expected.toString().equals(new BigInt("888888888888888888")
                    .plus(new BigInt("-999999999999999999")).toString()));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

    }

    public static void test_DivideByTwo() {
        System.out.println("Testing DivideByTwo...");

        

    }

}

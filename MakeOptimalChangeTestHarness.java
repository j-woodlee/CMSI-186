public class MakeOptimalChangeTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        test_Canada();
        test_JakeUniverse();
        //test_USARecursive();
        // Add more!

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_USARecursive() {
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        Tally result = MakeOptimalChange.makeOptimalChangeRecursively(usaDenominations, 99);
        //System.out.println(result);
        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        //System.out.println(result);

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_USA() {
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        Tally result = MakeOptimalChange.makeOptimalChange(usaDenominations, 99);
        //System.out.println(result);
        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        //System.out.println(result);

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void test_Canada() {

        int[] canadaDenominations = new int[] {25, 10, 5, 100};

        Tally result = MakeOptimalChange.makeOptimalChange(canadaDenominations, 99);
        //System.out.println(result);

        try {
            displaySuccessIfTrue(result.isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        result = MakeOptimalChange.makeOptimalChange(canadaDenominations, 25);

        try {
            displaySuccessIfTrue(result.getElement(0) == 1);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(result.getElement(1) == 0);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(result.getElement(2) == 0);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(result.getElement(3) == 0);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        result = MakeOptimalChange.makeOptimalChange(canadaDenominations, 26);

        try {
            displaySuccessIfTrue(result.isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        result = MakeOptimalChange.makeOptimalChange(canadaDenominations, 30);

        try {
            displaySuccessIfTrue(result.getElement(0) == 1);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(result.getElement(1) == 0);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(result.getElement(2) == 1);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(result.getElement(3) == 0);
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

    }

    public static void test_JakeUniverse() {

        int[] jakeDenominations = new int[] {1,3,5,8,13,21};

        Tally result = MakeOptimalChange.makeOptimalChange(jakeDenominations, 99);
        //System.out.println(result);
        try {
            displaySuccessIfTrue(4 == result.getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        result = MakeOptimalChange.makeOptimalChange(jakeDenominations, 1);

        try {
            displaySuccessIfTrue(0 == result.getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        jakeDenominations = new int[] {3,5,8,13,21};
        result = MakeOptimalChange.makeOptimalChange(jakeDenominations, 101);

        //System.out.println(result);

        try {
            displaySuccessIfTrue(4 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

    }

}

public class MakeOptimalChange {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {
            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.");
                System.out.println();
                printUsage();
                return;
            }

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.");
                    System.out.println();
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.");
                        System.out.println();
                        printUsage();
                        return;
                    }
                }
            }

            Tally change = makeOptimalChange(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.");
            System.out.println();
            printUsage();
        }
    }

    public static Tally makeOptimalChangeRecursively(int[] denominations, int amount) {
        Tally[][] tallyTable = new Tally[denominations.length][amount + 1];

        for(int i = 0; i < denominations.length; i++) {//fill in zeroes
            tallyTable[i][0] = new Tally(denominations.length);
        }

        return getTallyAt(denominations.length, amount, denominations, tallyTable);        
    }

    public static Tally getTallyAt(int i, int j, int[] denominations, Tally[][] tallyTable) {
                if(j >= denominations[i]) {
                    Tally t = new Tally(denominations.length);//prime new Tally 
                    t.setElement(i,1);
                    Tally difference = getTallyAt(i, j - denominations[i], denominations, tallyTable);

                    if (i == 0) {

//if (j == 25) {
   // System.out.println("at " + i + " , " + j + ": " + difference);
    //System.out.println("at " + i + " , " + j + ": " + tallyTable[0][0]);
///}

                        if(difference.isImpossible()) {
                            t = Tally.IMPOSSIBLE;
                        } else {
                            t = t.add(difference);
                        }
                    } else {
                        Tally cameBefore = getTallyAt(i - 1, j, denominations, tallyTable);
                        if(difference.isImpossible()) {
                            t = cameBefore;
                        } else {
                            t = t.add(difference);
                        }
                        if(!cameBefore.isImpossible() && t.total() > cameBefore.total()) {
                            t = cameBefore;
                        }
                    }

                    tallyTable[i][j] = t;
                } else {
                    if(i > 0) {
                        tallyTable[i][j] = getTallyAt(i - 1, j, denominations, tallyTable);
                    } else {
                        tallyTable[i][j] = Tally.IMPOSSIBLE;
                    }     
                }

                        return tallyTable[i][j];
    }

    public static Tally makeOptimalChange(int[] denominations, int amount) {
        Tally[][] tallyTable = new Tally[denominations.length][amount + 1];

        for(int i = 0; i < denominations.length; i++) {//fill in zeroes
            tallyTable[i][0] = new Tally(denominations.length);
        }

        for(int i = 0; i < denominations.length; i++) {
            for(int j = 1; j < tallyTable[i].length; j++) {
                if(j >= denominations[i]) {
                    Tally t = new Tally(denominations.length);//prime new Tally 
                    t.setElement(i,1);
                    Tally difference = tallyTable[i][j-denominations[i]];

                    if (i == 0) {

//if (j == 25) {
   // System.out.println("at " + i + " , " + j + ": " + difference);
    //System.out.println("at " + i + " , " + j + ": " + tallyTable[0][0]);
///}

                        if(difference.isImpossible()) {
                            t = Tally.IMPOSSIBLE;
                        } else {
                            t = t.add(difference);
                        }
                    } else {
                        Tally cameBefore = tallyTable[i-1][j];
                        if(difference.isImpossible()) {
                            t = cameBefore;
                        } else {
                            t = t.add(difference);
                        }
                        if(!cameBefore.isImpossible() && t.total() > cameBefore.total()) {
                            t = cameBefore;
                        }
                    }

                    tallyTable[i][j] = t;
                } else {
                    if(i > 0) {
                        tallyTable[i][j] = tallyTable[i-1][j];
                    } else {
                        tallyTable[i][j] = Tally.IMPOSSIBLE;
                    }     
                }
            }
        }

        //for(int i = 0; i < denominations.length; i++) {
          //  for(int j = 0; j < tallyTable[i].length; j++) {
             //   System.out.println(tallyTable[i][j]);
           // }
        //}

        return tallyTable[denominations.length - 1][amount];

    }

    private static void printUsage() {
        System.out.println("Usage: java MakeOptimalChange <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}

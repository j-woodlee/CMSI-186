public class AngryBallsTestHarness {
    static int attempts = 0;
    static int successes = 0;

    public static void main(String[] args){
        VectorTestHarness.main(args);
        BallTestHarness.main(args);
        AngryBallsSimulationTestHarness.main(args);

        attempts = VectorTestHarness.attempts + BallTestHarness.attempts + AngryBallsSimulationTestHarness.attempts;
        successes = VectorTestHarness.successes + BallTestHarness.successes + AngryBallsSimulationTestHarness.successes;

        System.out.println(successes + "/" + attempts + " Total tests passed.");

        if(VectorTestHarness.successes == VectorTestHarness.attempts && BallTestHarness.successes == BallTestHarness.attempts && AngryBallsSimulationTestHarness.successes == AngryBallsSimulationTestHarness.attempts) {
            System.out.println("All Tests passed.");

        } else {
            System.out.println("At least one test has failed.");
        }

    }
}

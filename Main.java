public class Main {
    public static void main(String[] args) {
        String mode = args[0];
        final int PhilopsofCount = 5;
        Fork[] forks = new Fork[PhilopsofCount];

        for (int i = 0; i < PhilopsofCount; i++) {
            forks[i] = new Fork(i);
        }
        Solution strategy;
        if ("run=problem".equals(mode)) {
            strategy = new Strategy();
        } else {
            strategy = new StrategySolution();
        }
        Thread[] philopsofs = new Thread[PhilopsofCount];
        for (int i = 0; i < PhilopsofCount; i++) {
            philopsofs[i] = new Philopsof(
                    i,
                    forks[i],
                    forks[(i + 1) % PhilopsofCount],
                    strategy
            );
            philopsofs[i].start();
        }
    }
}
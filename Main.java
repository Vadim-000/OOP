public class Main {
    public static void main(String[] args) {
        if (args.length != 1)
            System.out.println("отсутствуют параметры");
        else {
            String mode = args[0];
            if ("run=problem".equals(mode)) {
                work(new Strategy());
            } else if ("run=solution".equals(mode)) {
                work(new StrategySolution());
            } else
                System.out.println("некоректные параметры, введите run=problem или run=solution");

        }
    }

    private static void work(Solution strategy) {
        final int PhilopsofCount = 5;
        Fork[] forks = new Fork[PhilopsofCount];

        for (int i = 0; i < PhilopsofCount; i++) {
            forks[i] = new Fork(i);
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
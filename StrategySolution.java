public class StrategySolution implements Solution{
    @Override
    public boolean pickUpFork(Philopsof philosopher) {
        Fork first = (philosopher.getId() % 2 == 0) ?
                philosopher.getLeftFork() : philosopher.getRightFork();
        Fork second = (philosopher.getId() % 2 == 0) ?
                philosopher.getRightFork() : philosopher.getLeftFork();

        while (!first.take()) {
            try { Thread.sleep(10); }
            catch (InterruptedException e) { return false; }
        }

        if (!second.take()) {
            first.put();
            return false;
        }

        return true;
    }

    @Override
    public void putFork(Philopsof philosopher) {
        philosopher.getLeftFork().put();
        philosopher.getRightFork().put();
    }
}


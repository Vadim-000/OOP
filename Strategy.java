public class Strategy implements Solution{

    @Override
    public boolean pickUpFork(Philopsof philosopher) {
        while (!philosopher.getLeftFork().take()) {
            try { Thread.sleep(10); } catch (InterruptedException e) { return false; }
        }
        while (!philosopher.getRightFork().take()) {
            philosopher.getLeftFork().put();
            try { Thread.sleep(10); } catch (InterruptedException e) { return false; }
            while (!philosopher.getLeftFork().take()) {
                try { Thread.sleep(10); } catch (InterruptedException e) { return false; }
            }
        }
        return true;
    }

    @Override
    public void putFork(Philopsof philosopher) {
        philosopher.getLeftFork().put();
        philosopher.getRightFork().put();
    }
}

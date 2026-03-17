public class Strategy implements Solution{

    @Override
    public boolean pickUpFork(Philopsof philosopher)  throws InterruptedException{
        while (!philosopher.getLeftFork().take()) {
            try { Thread.sleep(4); } catch (InterruptedException e) { return false; }
        }
        Thread.sleep((long)(Math.random()*716));
        while (!philosopher.getRightFork().take()) {
            try { Thread.sleep(35); } catch (InterruptedException e) { return false; }
        }
        return true;
    }

    @Override
    public void putFork(Philopsof philosopher) {
        philosopher.getLeftFork().put();
        philosopher.getRightFork().put();
    }
}

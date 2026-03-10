public class Philopsof extends Thread{
    private int id;
    private Fork leftFork;
    private Fork rightFork;
    private Solution strategy;

    public Philopsof(int id,Fork leftFork,Fork rightFork, Solution strategy){
        this.id=id;
        this.leftFork=leftFork;
        this.rightFork=rightFork;
        this.strategy=strategy;
    }

    @Override
    public void run(){
        while (true){
            try {
                think();
                if (strategy.pickUpFork(this)){
                    eat();
                    strategy.putFork(this);
                }
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void think() throws InterruptedException {
        System.out.println(id+" философ думает");
        Thread.sleep((long)(Math.random()*1000));
    }
    private void eat() throws InterruptedException {
        System.out.println(id+" философ ест");
        Thread.sleep((long)(Math.random()*1000));
    }
    public Fork getLeftFork(){return leftFork;}
    public Fork getRightFork(){return rightFork;}
    public int getIdP(){return id;}
}

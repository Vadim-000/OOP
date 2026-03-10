public class Fork {
    private int id;
    private volatile boolean isTaken=false;

    public Fork(int id){
        this.id=id;
    }

    public synchronized boolean take(){
        if (!isTaken){
            isTaken=true;
            return true;
        }
        return false;
    }
    public synchronized void put(){
        isTaken=false;
    }
    public int getId() {
        return id;
    }
}

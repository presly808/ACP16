package week4.multiThreads;

// some threads invoke 'inc', others invoke 'decr'
// 1. Make this class thread safe
// 2. Add conditions
// 3. thread cannot invoke increment while count doesn't equals 0
// 4. thread cannot invoke decrement while count equal 0


public class Container {

    private int count;
    private final Object MONITOR;

    public Container() {
        this.count = 0;
        this.MONITOR = getMONITOR();
    }

    private void inc() {// MONITOR this
        count++;
    }

    private void decr() {
        count--;
    }

    public void safeIncr(){
        synchronized (MONITOR){
            inc();
        }
    }

    public void safeDerc(){
        synchronized (MONITOR){
            decr();
        }
    }

    public Integer getCount() {
        return count;
    }

    public void safeSleepIncr() throws InterruptedException {
        synchronized (MONITOR){
            while (getMONITOR() != 0){
                MONITOR.wait();
            }
            inc();
            MONITOR.notifyAll();
        }
    }

    public void safeSleepDecr() throws InterruptedException {
        synchronized (MONITOR){
            while (getMONITOR() == 0){
                MONITOR.wait();
            }
            decr();
            MONITOR.notifyAll();
        }
    }

    private Integer getMONITOR(){
        return new Integer(count);
    }

}

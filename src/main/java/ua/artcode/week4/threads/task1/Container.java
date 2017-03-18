package ua.artcode.week4.threads.task1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */// some threads invoke 'inc', others invoke 'decr'
// 1. Make this class thread safe
// 2. Add conditions
//    thread cannot invoke increment while count doesn't equals 0
//    thread cannot invoke decrement while count equal 0
class Container {

    private int count;
    private final Object monitor;


    public Container(int count) {
        this.count = count;
        this.monitor = new Object();
    }

    public void inc() {// monitor this
        synchronized (monitor){
            while(count > 0){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            count++;

            monitor.notifyAll();
        }

    }

    public void decr() {
        synchronized (monitor){
            while(count <= 0){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            count--;
            monitor.notifyAll();
        }
    }

    public int getValue() {
        synchronized (monitor){
            return count;
        }
    }
}

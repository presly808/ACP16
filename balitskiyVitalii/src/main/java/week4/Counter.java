package week4;

import javax.management.monitor.Monitor;

/**
 * Created by Vitalii on 19.02.2017.
 */
public class Counter {

    private int counter;
    private Object monitor;

    public Counter(int counter) {
        this.counter = counter;
        monitor = new Object();
    }

    public void increment() throws InterruptedException {
        synchronized (monitor) {
            while (counter != 0) {
                monitor.wait();
                monitor.notifyAll();
            }
            counter++;
            System.out.println(counter);
            monitor.notifyAll();
        }
    }

    public void decrement() throws InterruptedException {
        synchronized (monitor) {
            while (counter == 0) {
                monitor.wait();
                monitor.notifyAll();
            }
            counter--;
            System.out.println(counter);
            monitor.notifyAll();
        }
    }
}

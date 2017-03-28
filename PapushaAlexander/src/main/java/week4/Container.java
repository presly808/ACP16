package week4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by alex on 19.02.17.
 */
public  class Container {

    public Container() {
    }

    private Lock lock = new ReentrantLock(true);
    private Condition producerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();


    private volatile int count;

    public void inc(){
        try {

            lock.lock();

            while (count != 0) {
                try {
                    producerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count++;
                consumerCondition.signal();
            }

        } finally {
            lock.unlock();
        }
    }


    public void decr(){
        try {
            lock.lock();

            while (count !=1){
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count--;
                producerCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

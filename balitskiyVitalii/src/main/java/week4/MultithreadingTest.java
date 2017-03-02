package week4;

/**
 * Created by Vitalii on 19.02.2017.
 */
public class MultithreadingTest {

    public static void main(String[] args) {

        Counter counter = new Counter(5);

        Thread addThread = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    counter.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread minusThread = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    counter.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        addThread.start();
        try {
            addThread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        minusThread.start();
        try {
            minusThread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}

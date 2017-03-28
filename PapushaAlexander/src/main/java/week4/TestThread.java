package week4;

/**
 * Created by alex on 19.02.17.
 */
public class TestThread {
    public static void main(String[] args) {
        Container container = new Container();


        new Thread(() -> {
            int count = 0;

            while (count != 100){
                if (container.getCount() > 0){

                    container.decr();
                    Thread.currentThread().notifyAll();
                    count++;

                } else {
                    try {

                        Thread.currentThread().wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        new Thread(() -> {
            int count = 0;
            while (count != 100){
                if (container.getCount() == 0){

                    container.inc();
                    Thread.currentThread().notifyAll();
                    count++;

                } else {
                    try {

                        Thread.currentThread().wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        System.out.println(container.getCount());
    }
}

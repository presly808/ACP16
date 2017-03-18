package ua.artcode.week4.threads.task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class TestContainer {

    public static final int ACTION_COUNT = 1_000;
    public static final int THREADS_COUNT = 100;
    private Container container;

    @Before
    public void setUp() {
        container = new Container(0);
    }


    private long runThreads(Runnable observer) throws InterruptedException, ExecutionException {


        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Boolean> future = executor.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                while (!Thread.currentThread().isInterrupted()) {
                    int value1 = container.getValue();
                    if (value1 < 0 || value1 > 1) {
                        throw new AssertionError("container value went from range 0-1, value " + value1);
                    }
                }

                return true;
            }
        });


        Thread observerThread = new Thread(observer);
        observerThread.setDaemon(true);

        if (observer != null) {
            observerThread.start();
        }


        long start = System.currentTimeMillis();

        List<Thread> threadList = new ArrayList<>();

        for (int j = 0; j < THREADS_COUNT; j++) {
            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < ACTION_COUNT; i++) {
                    container.inc();
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < ACTION_COUNT; i++) {
                    container.decr();
                }
            });

            threadList.add(thread1);
            threadList.add(thread2);

            thread1.start();
            thread2.start();
        }


        for (Thread thread : threadList) {
            thread.join();
        }

        long end = System.currentTimeMillis();


        //future.cancel(false);
        executor.shutdownNow();
        Boolean res = future.get();
        Assert.assertTrue(res);

        return end - start;
    }

    @Test
    public void testIncDecSimple() throws InterruptedException, ExecutionException {

        long executionTime = runThreads(null);

        /*
        threadList.forEach((th) -> {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/

        System.out.printf("execution time %d, value %d", executionTime, container.getValue());

        Assert.assertEquals(0, container.getValue());

    }

    @Test
    public void testIncDecWithConditions() throws InterruptedException, ExecutionException {

        Runnable observer = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    int value1 = container.getValue();
                    if (value1 < 0 || value1 > 1) {
                        System.out.println("container value went from range 0-1, value " + value1);
                        throw new AssertionError("container value went from range 0-1, value " + value1);
                    } /*else if(value1 == 1) {
                        System.out.println("value1 " + );
                    }*/
                }
            }
        };

        long executionTime = runThreads(observer);



        /*
        threadList.forEach((th) -> {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/


    }


}

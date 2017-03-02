package week4.multiThreads;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestContainer {

    private Container container;
    private Thread threadIncr;
    private Thread threadDecr;
    private int  quantity;
    private int expectedCount;

    @Before
    public void prepareData(){
        this.container = new Container();
        quantity = 100000;
        expectedCount = 0;

        threadIncr = new Thread(() -> {
            for (int i = 0; i < quantity; i++) {
                container.safeIncr();
            }
        });

        threadDecr = new Thread(() -> {
            for (int i = 0; i < quantity; i++) {
                container.safeDerc();
            }
        });
    }

    @Test
    public void testSafeSleepIncr() throws InterruptedException {
        threadIncr.start();
        threadDecr.start();

        threadIncr.join();
        threadDecr.join();
        Assert.assertTrue(expectedCount == container.getCount());
    }

}

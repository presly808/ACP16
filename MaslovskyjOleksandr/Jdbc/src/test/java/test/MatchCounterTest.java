package test;

import mathCounting.MatchCounter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;

public class MatchCounterTest {

    private String directoryPath;
    private String keyWord;
    private int expectedResult;

    @Before
    public void prepareData(){
        this.directoryPath = "/home/ubuntu/IdeaProjects/ACP16";
        this.keyWord = "class";
        this.expectedResult = 98;
    }

    @Test
    public void testMatchCounterInOneThread(){
        long start= System.currentTimeMillis();
        MatchCounter matchCounter = new MatchCounter(new File(directoryPath), keyWord);
        int actualResult = matchCounter.find();
        long end= System.currentTimeMillis();
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void testMatchCounterInMultyThreading() throws ExecutionException, InterruptedException, IOException {
        long start= System.currentTimeMillis();
        MatchCounter matchCounter = new MatchCounter(new File(directoryPath), keyWord);

        long actualResult = matchCounter.findQuantityOf();

        long end= System.currentTimeMillis();
        long multiThreadTime = end - start;

        Assert.assertTrue(expectedResult == actualResult);
        Assert.assertTrue(multiThreadTime < calculateMatchCounterInOneThread());
    }

    private long calculateMatchCounterInOneThread(){
        long start= System.currentTimeMillis();
        MatchCounter matchCounter = new MatchCounter(new File(directoryPath), keyWord);
        matchCounter.find();
        long end= System.currentTimeMillis();
        return end - start;
    }
}

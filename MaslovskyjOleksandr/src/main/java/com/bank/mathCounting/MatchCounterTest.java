package com.bank.mathCounting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.concurrent.*;

public class MatchCounterTest {

    private String directoryPath;
    private String keyWord;
    private int expectedResult;
    private long oneThreadTime;
    private final int THREADS_NUMBER = 10;

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
        oneThreadTime = end - start;
        Assert.assertTrue(expectedResult == actualResult);
    }

    @Test
    public void testMatchCounterInMultyThreading() throws ExecutionException, InterruptedException {
        long start= System.currentTimeMillis();
        MatchCounter matchCounter = new MatchCounter(new File(directoryPath), keyWord);

        int actualResult = 0;
        for (int i = 0; i < THREADS_NUMBER; i++) {
            try {
                RunnableFuture<Integer> future = new FutureTask(() -> matchCounter.find(true));
                future.run();
                actualResult += future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long end= System.currentTimeMillis();
        long multiThreadTime = end - start;

        Assert.assertTrue(multiThreadTime < oneThreadTime);
        Assert.assertTrue(expectedResult == actualResult);
    }
}
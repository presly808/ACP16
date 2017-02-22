package com.bank.mathCounting;


import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MultiThreadingMatcher implements Callable<Integer>{

    private MatchCounter matchCounter;

    public MultiThreadingMatcher(MatchCounter matchCounter) {
        this.matchCounter = matchCounter;
    }

    @Override
    public Integer call() throws Exception {
        return matchCounter.find();
    }
}

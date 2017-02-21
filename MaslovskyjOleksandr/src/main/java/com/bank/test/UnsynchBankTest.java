package com.bank.test;

import com.bank.bank.Bank;
import com.bank.bank.TransferRunnable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnsynchBankTest {

    public int accounts;
    public double initialBalance;

    @Before
    public void initData(){
        this.accounts = 100;
        initialBalance = 1000;
    }

    @Test
    public void testUnSyncBankAction(){
        Bank bank = new Bank(accounts, initialBalance);

        for (int i = 0; i < accounts; i++) {
            TransferRunnable runnable = new TransferRunnable(bank, i, initialBalance);
            Thread thread = new Thread(runnable);
            thread.start();
        }

        double balance = bank.getTotalBalance();
        Assert.assertTrue(initialBalance == balance);
    }

}
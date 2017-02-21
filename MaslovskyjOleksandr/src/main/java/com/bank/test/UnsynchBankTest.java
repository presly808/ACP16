package com.bank.test;

import com.bank.bank.Bank;
import com.bank.bank.TransferRunnable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsynchBankTest {

    public int accounts;
    public double initialBalance;
    public double expectedBalance;

    @Before
    public void initData(){
        this.accounts = 100;
        initialBalance = 100_000;
        this.expectedBalance = accounts * initialBalance;
    }

    @Test
    public void testUnSyncBankAction() throws InterruptedException {
        Bank bank = new Bank(accounts, initialBalance);

        for (int account = 0; account < accounts; account++) {
            TransferRunnable runnable = new TransferRunnable(bank, account, initialBalance);
            Thread thread = new Thread(runnable);
            thread.start();
        }

        double actualBalance = 0;
        for (double account : bank.getAccounts()) {
            actualBalance = bank.getTotalBalance();
        }

        Assert.assertTrue(expectedBalance == actualBalance);
    }

}
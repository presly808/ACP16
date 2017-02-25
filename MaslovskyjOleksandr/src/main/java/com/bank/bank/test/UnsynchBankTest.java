package com.bank.bank.test;

import com.bank.bank.Bank;
import com.bank.bank.TransferRunnable;
import com.bank.bank.TransferRunnableReadWriteLock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void testUnSyncBankLockAction() throws InterruptedException {
        Bank bank = new Bank(accounts, initialBalance);

        for (int account = 0; account < accounts; account++) {
            TransferRunnable runnable = new TransferRunnable(bank, account, initialBalance);
            Thread thread = new Thread(runnable);
            thread.start();
        }

        double actualBalance = bank.getTotalBalance();

        Assert.assertTrue(expectedBalance == actualBalance);
    }

    @Test
    public void testUnSyncBankReadWriteAction() throws InterruptedException {
        Bank bank = new Bank(accounts, initialBalance);

        for (int account = 0; account < accounts; account++) {
            TransferRunnable runnable = new TransferRunnableReadWriteLock(bank, account, initialBalance);
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
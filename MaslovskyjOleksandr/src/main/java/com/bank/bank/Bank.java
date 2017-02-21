package com.bank.bank;


import org.apache.log4j.Logger;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    static final Logger LOGGER = Logger.getLogger(Bank.class);

    private final double[] accounts;
    private Lock monitor;
    private Condition cunsumerAccount;
    private Condition producerAccount;

    public Bank(int numberOfAccounts, double initialBalance) {
        LOGGER.info("INITIALIZE BANK");
        accounts = new double[numberOfAccounts];
        setAccountsBalance(initialBalance);
        this.monitor = new ReentrantLock(true); // use queue
        this.cunsumerAccount = monitor.newCondition();
        this.producerAccount = monitor.newCondition();
    }

    private void setAccountsBalance(double initialBalance) {
        for (int i = 0; i < accounts.length; i++){
            accounts[i] = initialBalance;
        }
    }

    public void transfer(int fromAccount, int toAccount, double amount) {
        if (accounts[fromAccount] < amount) {
            LOGGER.info("NOT ENOUGH MONEY TO TRANSFER");
            return;
        }
        LOGGER.info(Thread.currentThread());

        sendMoney(fromAccount, amount);
        acceptMoney(toAccount, amount);

        LOGGER.info("AMOUNT: " + amount + " FROM ACCOUNT: " +
                fromAccount + " TO --> " + toAccount + " TRANSFERRED");
        LOGGER.info("TOTAL BALANCE: " + getTotalBalance());
    }

    private void acceptMoney(int toAccount, double amount) {
        LOGGER.info("ACCEPT MONEY");
        monitor.lock();
        try {
            producerAccount.await();
            accounts[toAccount] += amount;
            cunsumerAccount.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            monitor.unlock();
        }
    }

    private void sendMoney(int fromAccount, double amount) {
        try {
            monitor.lock();
            cunsumerAccount.await();
            accounts[fromAccount] -= amount;
            producerAccount.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            monitor.unlock();
        }
    }

    public double getTotalBalance() {
        double sum = 0;
        LOGGER.info("CALCULATE TOTAL BANK BALANCE");
        for (double account: accounts){
            sum += account;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }

    public double[] getAccounts() {
        return accounts;
    }
}
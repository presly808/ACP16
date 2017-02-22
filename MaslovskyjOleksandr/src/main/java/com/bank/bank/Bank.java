package com.bank.bank;


import org.apache.log4j.Logger;

import java.util.concurrent.locks.*;

public class Bank {

    static final Logger LOGGER = Logger.getLogger(Bank.class);

    private final double[] accounts;
    private Lock monitor;
    private ReadWriteLock readWriteLock;
    private Condition cunsumerAccount;
    private Condition producerAccount;

    public Bank(int numberOfAccounts, double initialBalance) {
        LOGGER.info("INITIALIZE BANK");
        accounts = new double[numberOfAccounts];
        setAccountsBalance(initialBalance);
        this.monitor = new ReentrantLock(true); // use queue
        this.cunsumerAccount = monitor.newCondition();
        this.producerAccount = monitor.newCondition();
        this.readWriteLock = new ReentrantReadWriteLock(true);
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

    public void transferReadWriteLock(int fromAccount, int toAccount, double amount) {
        if (accounts[fromAccount] < amount) {
            LOGGER.info("NOT ENOUGH MONEY TO TRANSFER");
            return;
        }
        LOGGER.info(Thread.currentThread());

        sendMoneyReadWriteLock(fromAccount, amount);
        acceptMoneyReadWriteLock(toAccount, amount);

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

    private void acceptMoneyReadWriteLock(int toAccount, double amount) {
        LOGGER.info("ACCEPT MONEY");
        readWriteLock.writeLock().lock();
        try {
            readWriteLock.writeLock().wait();
            accounts[toAccount] += amount;
            readWriteLock.writeLock().newCondition().signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
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

    private void sendMoneyReadWriteLock(int fromAccount, double amount) {
        readWriteLock.readLock().lock();
        try {
            readWriteLock.readLock().wait();
            accounts[fromAccount] -= amount;
            readWriteLock.readLock().newCondition().signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
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
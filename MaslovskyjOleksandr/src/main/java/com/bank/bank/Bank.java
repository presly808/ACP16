package com.bank.bank;


import org.apache.log4j.Logger;

public class Bank {

    static final Logger LOGGER = Logger.getLogger(Bank.class);

    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        LOGGER.info("INITIALIZE BANK");
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++){
            accounts[i] = initialBalance;
        }
    }

    public void transfer(int fromAccount, int toAccount, double amount) {
        if (accounts[fromAccount] < amount) {return;}
        LOGGER.info(Thread.currentThread());
        accounts[fromAccount] -= amount;
        LOGGER.info(amount + " | " + fromAccount + " | " + toAccount);
        accounts[toAccount] += amount;
        LOGGER.info("TOTAL BALANCE: " + getTotalBalance());
    }

    private double getTotalBalance() {
        double sum = 0;
        LOGGER.info("CALCULATE TOTAL BALANCE");
        for (double a: accounts){
            sum += a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
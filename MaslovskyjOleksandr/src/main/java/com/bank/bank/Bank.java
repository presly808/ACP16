package com.bank.bank;


import org.apache.log4j.Logger;

public class Bank {

    static final Logger LOGGER = Logger.getLogger(Bank.class);

    private final double[] accounts;

    public Bank(int numberOfAccounts, double initialBalance) {
        LOGGER.info("INITIALIZE BANK");
        accounts = new double[numberOfAccounts];
        setAccountsBalance(initialBalance);
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

        withdrawTheAmount(fromAccount, amount);
        considerMoney(toAccount, amount);

        LOGGER.info("AMOUNT: " + amount + " FROM ACCOUNT: " +
                fromAccount + " TO --> " + toAccount + " TRANSFERRED");
        LOGGER.info("TOTAL BALANCE: " + getTotalBalance());
    }

    private void considerMoney(int toAccount, double amount) {
        LOGGER.info("ACCEPT MONEY");
        accounts[toAccount] += amount;

    }

    private void withdrawTheAmount(int fromAccount, double amount) {
        accounts[fromAccount] -= amount;
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
}
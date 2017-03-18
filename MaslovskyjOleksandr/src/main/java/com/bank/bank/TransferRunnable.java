package com.bank.bank;

import org.apache.log4j.Logger;

public class TransferRunnable implements Runnable {

    final static Logger LOGGER = Logger.getLogger(TransferRunnable.class);

    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY;

    public TransferRunnable(Bank bank, int fromAccount, double max) {
        LOGGER.info("INITIALIZE TRANSFER");
        this.bank = bank;
        this.fromAccount = fromAccount;
        maxAmount = max;
        this.DELAY  = 10;
    }

    @Override
    public void run() {

        try {
            while (true){
                LOGGER.info("RUN ACTION");
                int toAccount = generateDestinationAccount();
                double amount = generateAmount();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep(generateTime());
            }
        }
        catch (InterruptedException e){}
    }

    protected int generateTime() {
        return (int) (DELAY*Math.random());
    }

    protected double generateAmount() {
        return maxAmount*Math.random();
    }

    protected int generateDestinationAccount(){
        return (int) (bank.size()*Math.random());
    }

    public Bank getBank() {
        return bank;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public int getDELAY() {
        return DELAY;
    }
}
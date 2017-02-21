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
                int toAccount = (int) (bank.size()*Math.random());
                double amount = maxAmount*Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((int) (DELAY*Math.random()));
            }
        }
        catch (InterruptedException e){}
    }
}
package bank;

import org.apache.log4j.Logger;

public class TransferRunnableReadWriteLock extends TransferRunnable{

    private Bank bank;
    private int fromAccount;
    private double amount;

    final static Logger LOGGER = Logger.getLogger(TransferRunnable.class);

    public TransferRunnableReadWriteLock(Bank bank, int fromAccount, double max) {
        super(bank, fromAccount, max);
        this.bank = getBank();
        this.fromAccount = getFromAccount();
        this.amount = getMaxAmount();
    }

    @Override
    public void run() {

        try {
            while (true){
                LOGGER.info("RUN ACTION");
                int toAccount = generateDestinationAccount();
                double amount = generateAmount();
                bank.transferReadWriteLock(fromAccount, toAccount, amount);
                Thread.sleep(generateTime());
            }
        }
        catch (InterruptedException e){}
    }

}

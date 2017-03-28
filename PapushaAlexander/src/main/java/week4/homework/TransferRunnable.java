package week4.homework;

/**
 * Created by alex on 25.02.17.
 */
public class TransferRunnable implements Runnable {
    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunnable(Bank b, int from, double max) {
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    @Override
    public void run() {

        try {
            while (true){
                int toAccount = (int) (bank.size()*Math.random());
                double amount = maxAmount*Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep(1000);
                System.out.println();

            }
        }
        catch (InterruptedException e){}


    }
}

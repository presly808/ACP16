package week4.homework;

/**
 * Created by alex on 25.02.17.
 */
public class UnsynchBankTest {

    public static final int NACCOUNTS = 3;
    public static final int INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

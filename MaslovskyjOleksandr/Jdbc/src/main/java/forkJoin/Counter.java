package forkJoin;

import org.apache.log4j.Logger;

public class Counter {

    static final Logger LOGGER = Logger.getLogger(Counter.class);

    public static final int THRESHOLD = 1000;
    private double[] values;
    private int fromAccount;
    private int toAccount;
    private Filter filter;

    public Counter(double[] values, int fromAccount, int toAccount, Filter filter) {
        LOGGER.info("INITIALIZE COUNTER");
        this.values = values;
        this.filter = filter;
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
    }

    public Integer compute() {
        if (toAccount - fromAccount < THRESHOLD) {
            LOGGER.info("CALCULATE ACCEPTED TRANSACTIONS");
            int count = 0;
            for (int i = fromAccount; i < toAccount; i++) {
                if (filter.accept(values[i])) {
                    count++;
                }
            }
            return count;

        } else {
            LOGGER.info("RECALCULATE TRANSACTION");
            int mid = (fromAccount + toAccount) / 2;
            Counter first = new Counter(values, fromAccount, mid, filter);
            Counter second = new Counter(values, mid, toAccount,  filter);

            return first.compute() + second.compute();
        }
    }
}
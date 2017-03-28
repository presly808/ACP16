package week4;

/**
 * Created by alex on 22.02.17.
 */
public class _01ThreadIntro {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

}

class MyThread extends Thread {

    private String threadDescription;

    public MyThread(String threadDescription) {
        this.threadDescription = threadDescription;
    }

    @Override
    public void run() {

        while(!isInterrupted()){

            System.out.printf("My work %s, %s, %s\n", getId(), getName(), getState());

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                interrupt();
            }

        }
    }
}

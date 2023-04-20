package src.com.concurrency2.ab;

import java.util.Random;

public class CounterIncream extends Thread{

    private volatile boolean terminated = false;

    private int counter = 0;

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try {
        while (!terminated){
            System.out.println(Thread.currentThread().getName() + " " + counter++);
            Thread.sleep(random.nextInt(1000));
        }
    } catch (InterruptedException e) {
            //e.printStackTrace();
        } finally {
        this.clean();
        }
        }
    private void clean(){
        System.out.println("The Thread is clean"+counter);
    }
    public void close(){
        this.terminated = true;
        this.interrupt();
    }
}

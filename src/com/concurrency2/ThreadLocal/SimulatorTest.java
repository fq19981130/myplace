package src.com.concurrency2.ThreadLocal;

import java.util.Random;

public class SimulatorTest {

    private final static Simulator<String> threadLocal= new Simulator<String>(){
        @Override
        public String initialValue(){
            return "No Value";
        }
    };

    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            threadLocal.set("Thread1-T1");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "" + threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            threadLocal.set("Thread1-T2");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

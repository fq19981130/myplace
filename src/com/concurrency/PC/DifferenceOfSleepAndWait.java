package src.com.concurrency.PC;

import java.util.stream.Stream;

public class DifferenceOfSleepAndWait {

    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        //m1();
        //m2();
        Stream.of("T1","T2").forEach(name->{
            new Thread(name){
                @Override
                public void run() {
                    m1();
                }
            }.start();
        });
    }
    public static void m1(){
        synchronized (LOCK){
            try {
                System.out.println("The Thread"+Thread.currentThread().getName()+"enter.");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //使用wait时应当加锁
    public static void m2() {
        synchronized (LOCK) {
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

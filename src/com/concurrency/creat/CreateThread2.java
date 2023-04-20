package src.com.concurrency.creat;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateThread2 {
    public static void main(String[] args) {

        Thread t = new Thread(){
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        t.start();
        //System.out.println(t.getThreadGroup());
        //System.out.println(Thread.currentThread().getName());
        //System.out.println(Thread.currentThread().getThreadGroup().getName());

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

        System.out.println(threadGroup.activeCount());
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);
//        for (Thread temp:threads){
//            System.out.println(temp);
//        }
    }
}

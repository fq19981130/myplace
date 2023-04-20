package src.com.concurrency2.wait;

import java.util.Optional;
import java.util.stream.IntStream;

public class WaitSet {

    private static final Object LOCK = new Object();
    /**
     * 1、所有的对象都会有一个wait set，用来存放调用了改对象wait方法之后进入block状态线程
     * 2、线程被notify之后，不一定立即执行
     * 3、线程从wait set中被唤醒顺序不一定是FIFO
     * 4、线程被唤醒后必须重新获取锁
     * @param args
     * */
    public static void main(String[] args) {

        IntStream.rangeClosed(1,10).forEach( i ->
            new Thread(String.valueOf(i)){
                @Override
                public void run(){
                    synchronized (LOCK){
                        try {
                            Optional.of(Thread.currentThread().getName()+"will come to wait set.")
                                    .ifPresent(System.out::println);
                            LOCK.wait();
                            Optional.of(Thread.currentThread().getName()+"will leave to wait set.")
                                    .ifPresent(System.out::println);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Thread will out.");
                    }
                }
            }.start()
        );

        try {
            Thread.sleep(300_00L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        IntStream.rangeClosed(1,10).forEach( i ->{
            synchronized (LOCK) {
                LOCK.notify();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

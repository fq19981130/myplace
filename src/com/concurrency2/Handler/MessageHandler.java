package src.com.concurrency2.Handler;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageHandler {

    private final Random random = new Random(System.currentTimeMillis());

    private final static Executor excutore = Executors.newFixedThreadPool(5);

    public void request(Message message){
        excutore.execute(()->{
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The message will be handly by" + Thread.currentThread().getName() + " "+value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        new Thread(()->{
//            String value = message.getValue();
//            try {
//                Thread.sleep(random.nextInt(1000));
//                System.out.println("The message will be handly by" + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
    public void shutdown(){
        ((ExecutorService)excutore).shutdown();
    }
}

package src.com.concurrency.PC;

import java.util.stream.Stream;

//notify,线程间通信
public class ProducerConsumerVersion2 {

    private int i = 0;

    final private Object LOCK = new Object();

    private volatile boolean isProduced = false;

    public void produce(){
        synchronized (LOCK){
            if (isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println("P->"+i);
                LOCK.notify();
                isProduced = true;
            }
        }
    }
    public void consume(){
        synchronized (LOCK){
            if (isProduced){
                System.out.println("C->" + i);
                LOCK.notify();
                isProduced = false;
            }else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        ProducerConsumerVersion2 pc = new ProducerConsumerVersion2();
        Stream.of("P1", "P2").forEach(n ->
                new Thread() {
                    @Override
                    public void run() {
                        while (true)
                            pc.produce();
                    }
                }.start()
        );
        Stream.of("C1", "C2").forEach(n ->
                new Thread() {
                    @Override
                    public void run() {
                        while (true)
                            pc.consume();
                    }
                }.start()
        );
    }
}

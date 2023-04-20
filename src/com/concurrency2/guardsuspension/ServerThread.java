package src.com.concurrency2.guardsuspension;

import java.util.Random;

public class ServerThread extends Thread{

    private final RequestQueue queue;

    private final Random random;

    private volatile boolean flag = false;
    private boolean closed;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!flag){
            Request request = queue.getRequest();
            if (null == request){
                System.out.println("Recived the enpty request");
                continue;
            }
            System.out.println("Server ->" + request.getValue());
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                return;
            }
        }

    }
    public void close(){
        this.closed = true;
        this.interrupt();
    }
}

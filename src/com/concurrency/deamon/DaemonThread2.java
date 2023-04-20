package src.com.concurrency.deamon;
//守护线程
public class DaemonThread2 {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            Thread innerthread =  new Thread(() ->{
                try {
                    while (true){
                        System.out.println("do nothing");
                        Thread.sleep(1_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //innerthread.setDaemon(true);
            innerthread.start();

            try {
                Thread.sleep(1_000);
                System.out.println("T thread finished done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t.setDaemon(true);
        t.start();
    }
}

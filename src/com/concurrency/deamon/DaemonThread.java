package src.com.concurrency.deamon;
//守护线程
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(){
            @Override
            public void run(){
                try {
                    System.out.println(Thread.currentThread().getName()+"Running");
                    Thread.sleep(100000);
                    System.out.println(Thread.currentThread().getName()+"done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };//new
        //runnable ->running ->dead ->block
        t.start();
        Thread.sleep(50_100);
        System.out.println(Thread.currentThread().getName());
    }
}

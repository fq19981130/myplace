package src.com.concurrency.ticket;


import sun.rmi.runtime.NewThreadAction;

public class TicketWindowRunnable implements Runnable{

    private int index = 1;

    private final static int MAX = 500;

    private final Object MONITOR = new Object();

    @Override
    public void run(){

        while (true){
            //1
            synchronized (MONITOR){
                if (index>MAX)
                    break;
                System.out.println(Thread.currentThread() + "的号码是："+(index++));
            }
        }
    }
}

package src.com.concurrency.ticket;

public class SynchronizedRunnable implements Runnable{
    private int index = 1;

    private final static int MAX = 500;

    private final Object MONITOR = new Object();

    @Override
    public  void run(){

        while (true){
            //1
            // synchronized (MONITOR){
//                if (index>MAX)
//                    break;
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread() + "的号码是："+(index++));
            if (ticket())
                break;
        }
    }
    private synchronized boolean ticket(){
        //1.getField
        if (index>MAX)
            return true;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //index++=>index = index+1
        //1.getField
        //2.index++=>index = index+1
        //3.put field index
        System.out.println(Thread.currentThread() + "的号码是："+(index++));
        return false;
    }
}



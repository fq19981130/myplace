package src.com.concurrency.synchronize;
//this锁
public class SynchronizeThis {
    public static void main(String[] args) {

        ThisLock thisLock = new ThisLock();
        new Thread("T1"){
            @Override
            public void run(){
                thisLock.m1();
            }
        }.start();
        new Thread("T2"){
            @Override
            public void run(){
                thisLock.m2();
            }
        }.start();
    }

    static class ThisLock {

        private final Object LOCK = new Object();

        public synchronized void m1() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void m2() {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
